package expressions;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Diagram extends JFrame implements MouseWheelListener {
    private int lastX;
    private int lastY;
    private int dx;
    private int dy;
    private int offsetX;
    private int offsetY;
    private static double[] horizontal;
    private static double[] vertical;
    private int width;
    private int height;
    private double zoomFactor = 1;
    public Diagram(double[] hor , double[] ver) {
        // == get data from expression class ==
        horizontal = hor;
        vertical = ver;
        // == init scrolling values ==
        lastX = 0;
        lastY = 0;
        offsetX = 0;
        offsetY = 0;
        dx = 0;
        dy = 0;
        // == set a size for window ==
        width = 800;
        height = 800;
        setSize(width,height);
        // == set a title for it ==
        setTitle("Diagram");
        // == add mouse listener for zooming and scroling ==
        addMouseWheelListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // == get wvery sec dragging mouse pos ==
        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                //System.out.println("herererer");
                dx = e.getX() - lastX;
                dy = e.getY() - lastY;
                offsetX += dx;
                offsetY += dy;
                // Adjust the position of drawn objects based on dx and dy
                // Example: Update the position of the drawn objects
                // objectX += dx;
                // objectY += dy;
                // Repaint the panel
                repaint();
                lastX = e.getX();
                lastY = e.getY();
                
            }
        });

        // == get last pos of mouse ==
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lastX = e.getX();
                lastY = e.getY();
            }
        });
        // == add panel to window ==
        add(new DiagramPanel());
        
    }

    // == zoom in or zoom out on diagram ==
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int notches = e.getWheelRotation();
        if (notches < 0 && zoomFactor <= 2) {
            zoomFactor *= 1.05;
        } else if (notches > 0 && zoomFactor >= 0.5){
            zoomFactor /= 1.05;
        }
        
        repaint();
    }
    
    // == make diagarm in a panel and then add it to frame (window) ==
    class DiagramPanel extends JPanel {
        // == paint (draw) the diagram with given data ==
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.translate(offsetX, offsetY);
            g2d.scale(zoomFactor, zoomFactor);
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(3));
            g2d.drawLine(0, height/2+1, width, height/2+1);
            g2d.drawLine(width/2+1, height , width/2+1, 0);
            for (int i = 0; i<horizontal.length-1; i++) {
                int hor1 = (int) horizontal[i]*10;
                int hor2 = (int) horizontal[i+1]*10;
                int ver1 = (int) vertical[i]*10;
                int ver2 = (int) vertical[i+1]*10;
                g2d.setColor(Color.red);
                g2d.drawLine((width/2+1) + hor1 ,(height/2+1) - ver1 ,(width/2+1) + hor2 ,(height/2+1) - ver2);
            }
        }
    }
    
}

