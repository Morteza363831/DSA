package S7;

public class S7q1 {
    
    
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(0);
        stack.push(15);
        stack.push(11);
        stack.push(6);
        stack.push(4);
        stack.findMaximum(stack.top);
        stack.elements();
        
    }
}
