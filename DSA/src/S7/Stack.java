package S7;

// stack is filo or lifo .. it means last data will exit first !
public class Stack {
    Node top;
    int size;
    public Stack () {
        this.top = null;
    }
    
    public void push(int val) {
        Node temp = new Node();
        
        // check stack is null or no ...
        if (temp == null) {
            System.out.println("\nHeap Overflow");
            return;
        }
        
        temp.data = val;
        temp.link = top;
        top = temp;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
    
    public int peek() {
        if (!isEmpty()) {
            return top.data;
        }
        else {
            System.out.println("Stack is empty");
            return -1;
        }
    }
    
    public void pop() {
        if (top == null) {
            System.out.printf("\nStack Underflow");
            return;
        }
        top = top.link;
        
    }
    
    public void elements() {
        if(isEmpty()) {
            System.out.println("stack is empty");
            return;
        }
        // make a copy for stack .. because we dont want to lose elements !
        Node temp = top;
        // make a while loop to print elements
        while (temp != null) {
            // print
            System.out.println(temp.data);
            // next top ...
            temp = temp.link;
        }
    }
    public void size() {
        size = 0;
        Node temp = top;
        while(temp != null) {
            size++;
            temp = temp.link;
        }
        System.out.println(size);
    }
    
    public void findMaximum(Node head) {
        Node firstEl = top;
        Node temp = null;
        head = top;
        int max = head.data;
        while (head.link != null) {
            if (head.link.data >= max) {
                max = head.link.data;
                temp = head;
            }
            head = head.link;
        }
        System.out.println(temp.link.data);
        top = temp;
        top.link =top.link.link;
        top = firstEl;
    }
    
    public void mergeStacks(Stack stack1, Stack stack2) {
        
        
        Node p1 = stack1.top;
        Node p2 = stack2.top;
        Node temp = null;
        while(p1 != null && p2 != null) {
            if (p2.data - p1.data == 1 || p2.data - p1.data == 0) {
                temp = p2.link;
                p2.link = p1.link;
                p1.link = p2;
                p1 = p1.link;
                p2 = temp;
            }
            else if (p1.data - p2.data == 1){
                temp = p2.link;
                p2.link = p1;
                p2 = temp;
                p1 = p1.link;
            }
            else if (p1.data - p2.data > 1){
                p2 = p2.link;
            }
            else if (p2.data - p1.data > 1) {
                p1 = p1.link;
            }
        }
        
        while (p2 != null) {
            
        }
    }
        
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.pop();
        stack.elements();
    }
}
