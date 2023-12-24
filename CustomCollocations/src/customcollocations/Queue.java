package customcollocations;

public class Queue<Object> {
    Node top;
    Node head;
    Node last;
    public void add(Object val) {
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
        return head == null;
    }
    public Object poll() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        top = head;
        head = top.link;
        Object val = (Object) top.data;
        top = last;
        return val;
    }
    
    public Object peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        top = head;
        Object val = (Object) top.data;
        top = last;
        return val;
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
        Queue<Integer> queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(2);
        queue.add(2);
        queue.add(2);
        for (int i = 0; i<6; i++) {
            if (queue.isEmpty()) {
                
            System.out.println(queue.isEmpty());
                break;
            }
            System.out.println(queue.poll());
            
        }
    }
}
