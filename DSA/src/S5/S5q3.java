package S5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class S5q3 {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack();
        
        s.add(1);
        s.add(2);
        s.add(3);
        q.add(s.pop());
        q.add(s.pop());
        q.add(s.pop());
        s.add(q.poll());
        s.add(q.poll());
        s.add(q.poll());
    }
}
