package S7;

public class Queue {
    Node top;
    Node head;
    Node last;
    public void push(int val) {
        if (top == null) {
            top = new Node();
            top.data = val;
            head = top;
        }
        else {
            Node temp = new Node();
            temp.data = val;
            top.link = temp;
            top = temp;
            last = top;
        }
        
    }
    
    public boolean isEmpty() {
        return top == null;
    }
    public void pop() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        top = head;
        head = top.link;
        int val = top.data;
        top = last;
        System.out.println(val);
    }
    
    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        top = head;
        int val = top.data;
        top = last;
        System.out.println(val);
    }
    
    public void display() {
        top = head;
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.link;
        }
        top = last;
    }
    
    public void remove() {
        top = head;
        head = top.link;
        top = last;
    }
    
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(10);
        queue.push(11);
        queue.push(12);
        queue.push(13);
        queue.remove();
        queue.pop();
        queue.peek();
        queue.display();
    }
}
