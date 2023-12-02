package S4;

import java.util.LinkedList;
import java.util.Queue;

public class S4q5 {
    public static void main(String[] args) {
        Queue q1 = new LinkedList();
        Queue q2 = new LinkedList();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(5);
        q2.add(q1.poll());
        q2.add(q1.poll());
        q2.add(q1.poll());
        q2.add(q1.poll());
        q2.add(q1.poll());
        System.out.println(q2.poll());
        System.out.println(q2.poll());
        System.out.println(q2.poll());
        System.out.println(q2.poll());
        System.out.println(q2.poll());
        
    }
}
