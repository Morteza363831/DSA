package S7;

public class S7q2 {
    
    public static void main(String[] args) {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        stack1.push(5);
        stack1.push(4);
        stack1.push(2);
        stack1.push(1);
        stack2.push(8);
        stack2.push(7);
        stack2.push(6);
        stack2.push(3);
        //stack1.mergeStacks(stack1, stack2);
        stack1.elements();
        System.out.println();
        stack2.elements();
        System.out.println();
        stack1.size();
    }
}
