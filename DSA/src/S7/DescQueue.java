package S7;

public class DescQueue {
    Node top;
    Node head;
    Node last;
    Node first;
    Node previous;
    public void push(int val) {
        if (top == null) {
            top = new Node();
            top.data = val;
            top.pre = null;
            previous = top;
            first = top;
        }
        else {
            Node temp = new Node();
            temp.data = val;
            top.next = temp;
            previous = top;
            top = temp;
            top.pre = previous;
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
        Node temp = top;
        int max = temp.data;
        int action = 0;
        while (temp != null) {
            if (temp.data >= max) {
                action = 0;
                head = temp;
                max = temp.data;
            }
            
            temp = temp.pre;
        }
        
        top = head;
        
        if (top.next == null && top.pre != null){
            last = top.pre;
            top.pre.next = null;
            top.pre = null;
        }
        else if (top.pre == null && top.next != null) {
            top.next.pre = null;
            top.next = null;
        }
        else if (top.pre == null && top.next == null) {
            max = last.data;
            top = null;
        }
        else if (top.pre != null) {
            top.pre.next = top.next;
            top.next.pre = top.pre;
            top = null;
        }

        top = last;
        head = null;
        System.out.println(max);
    }
    
    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        Node temp = top;
        int val = temp.data;
        int action = 0;
        while (temp != null) {
            if (temp.data >= val) {
                action = 0;
                head = temp;
                val = temp.data;
            }
            
            temp = temp.pre;
        }
        top = last;
        System.out.println(val);
    }
    
    public void display() {
        top = head;
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.pre;
        }
        top = last;
    }
    
    public void remove() {
        Node temp = top;
        int max = temp.data;
        int action = 0;
        while (temp != null) {
            if (temp.data >= max) {
                action = 0;
                head = temp;
                max = temp.data;
            }
            
            temp = temp.pre;
        }
        
        top = head;
        
        if (top.next == null && top.pre != null){
            last = top.pre;
            top.pre.next = null;
            top.pre = null;
        }
        else if (top.pre == null && top.next != null) {
            top.next.pre = null;
            top.next = null;
        }
        else if (top.pre == null && top.next == null) {
            max = last.data;
            top = null;
        }
        else if (top.pre != null) {
            top.pre.next = top.next;
            top.next.pre = top.pre;
            top = null;
        }

        top = last;
        head = null;
    }
    
    public static void main(String[] args) {
        DescQueue aq = new DescQueue();
        aq.push(5);
        aq.push(1);
        aq.push(4);
        aq.push(3);
        aq.push(2);
        aq.pop();
        aq.pop();
        aq.remove();
        aq.peek();
    }
}
