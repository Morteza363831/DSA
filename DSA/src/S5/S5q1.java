package S5;

import java.util.ArrayList;
import java.util.Stack;

public class S5q1 {
    public static void main(String[] args) {
        Stack<Character> s = new Stack();
        String func = "(2*3+4)";
        String res = "";
        for (int i = 0; i<func.length(); i++) {
            if (func.charAt(i) == '('){
                s.push('(');
                
            }
            else if (!s.isEmpty() && func.charAt(i) == ')') {
                for (int j = 0; j<s.size(); j++) {
                    
                    res = res + s.pop();
                }
            }
            else {
                // bad operand ...
                if (func.charAt(i) == '*') {
                    s.push('*');
                }
                else if (func.charAt(i) == '+') {
                    s.push('+');
                }
                else {
                    res = res + func.charAt(i);
                }
            }
        }
        System.out.println(res);
    }
}
