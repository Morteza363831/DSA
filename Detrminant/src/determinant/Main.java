package determinant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main {
    String path;
    File file;
    double[][] matrix;
    public Main() {
       
    }
    public void chooser() {
        // == choose a file from pc ==
        JFileChooser chooser = new JFileChooser();
        // == u can just choose txt files ==
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        chooser.setFileFilter(filter);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        // == check the choosen file ==
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            // == save the path ==
           path =  chooser.getSelectedFile().getAbsolutePath();
           path = path.replace('\\', '/');
           file = new File(path);
           
        }
    }
    public static double[][] matrixMaker(File file){
        double[][] matrix = null;
        try {
            // == check the file exists or no ==
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                int rowCount = 0;
                int columnCount = 0;
                // == get row and column count ==
                while (scanner.hasNextLine()) {
                    rowCount++;
                    String[] line = scanner.nextLine().split(" ");
                    columnCount = line.length;
                }
                // == if it is square matrix save it ==
                if (rowCount == columnCount) {
                    matrix = new double[rowCount][columnCount];

                    scanner = new Scanner(file);
                    // == save numbers in matrix for calculating determinant ==
                    for (int i = 0; i<rowCount; i++) {
                        // == get lines in file ==
                        String[] line = scanner.nextLine().split(" ");
                        for (int j = 0; j<columnCount; j++) {
                            matrix[i][j] = Double.parseDouble(line[j]);
                        }
                    }
                    scanner.close();
                    
                }
                else {
                    throw new NullPointerException("undefiend matrix");
                }
                
            }
            else {
                throw new NullPointerException("no file had choosed");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return matrix;
        
        
    }
    public static void main(String[] args) {
        Main m = new Main();
        m.chooser();
        m.matrix = matrixMaker(m.file);
        System.out.println(m.path);
        DeterminantImp di = new DeterminantImp();
        //
        //
        Scanner input = new Scanner(System.in);
        System.out.println("please choose a way to calculate matrix gaussian (0) laplase (1) omid (2) --> ");
        int action = input.nextInt();
        
        switch(action) {
            case 0 :
                System.out.println(di.gaussian(m.matrix, m.matrix.length));
                break;
            case 1 :
                di.N = m.matrix.length;
                System.out.println(di.laplase(m.matrix, m.matrix.length));
                break;
            case 2 :
                System.out.println(di.omid(m.matrix, m.matrix.length));
                break;
            default :
                System.out.println("please choose an action");
            
        }
        
        
    }
}
