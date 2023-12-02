package S5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class S5q2 {
    
    public static void subscription() {
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack();
        int res = 0;
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(5);
        s.add(7);
        s.add(5);
        s.add(2);
        s.add(3);
        s.add(5);
        s.add(1);
        while (!q.isEmpty() || !s.isEmpty()) {
            res = q.peek();
            if (q.poll() == s.pop()) {
                System.out.println(res);
            }
        }
    }
    public static void main(String[] args) {
        subscription();
    }
}
