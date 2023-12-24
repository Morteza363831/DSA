package expressions;

import java.text.DecimalFormat;
import java.util.LinkedList;
import customcollocations.Queue;
import customcollocations.Stack;
import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;


public class ExpressionsImp implements Expressions{
    
    private String expression;
    private StringBuilder result;
    private static Scanner input;
    private int resultNum;
    private Stack<Character> stack;
    private Queue<String> queue;
    private double[] horizontal;
    private double[] vertical;
    private ArrayList<Double> inf;
    
    
    public static void main(String[] args) {
        input = new Scanner(System.in);
        ExpressionsImp ei = new ExpressionsImp(input.nextLine());
        ei.evaluatorVar();
        //System.out.println(ei.postFix().getExpressions());
        //System.out.println(ei.postFixVar().getExpressions());
        //System.out.println(ei.evaluator().getExpressions());
    }
    
    // == constructor ==
    // == initial variables here ! ==
    public ExpressionsImp(String expressions) {
        
        stack = new Stack<>();
        queue = new Queue<>();
        result = new StringBuilder();
        horizontal = new double[100000];
        vertical = new double[100000];
        inf = new ArrayList<>();
        expression = "";
        resultNum = 0;
        this.expression = expressions;
    }
    
    // == get String  expressions ==
    public String getExpressions() {
        return this.expression;
    }
    
    // == override methods in Expressions interface ==
    
    // == post fix method ==
    // convert an infix expressions to a post fix expression ==
    @Override
    public ExpressionsImp postFix() {
        String expression = this.expression;
        // == iterate over expression ==
        for (int i = 0; i< expression.length(); i++) {
            // == if character on index i is not a number do some thing ... ==
            if (!Character.isDigit(expression.charAt(i))) {
                // == if it is ( push it on stack ==
                if (expression.charAt(i) == '(') {
                    stack.push(expression.charAt(i));
                }
                // == if it is ) pop operations those are in stack until the operation be ( ==
                else if (expression.charAt(i) == ')') {
                    while (stack.peek() != '(') {
                        queue.add(stack.pop() + "");
                    }
                    // == delete ( ==
                    stack.pop();
                }
                // == [ shows a two digit number .. ==
                else if (expression.charAt(i) == '[') {
                    StringBuilder num = new StringBuilder();
                    int j = i;
                    // == find two digit number between [] until u see ] ==
                    while (expression.charAt(j) != ']') {
                        num.append(expression.charAt(j));
                        j++;
                    }
                    num.append("]");
                    // == add two digit number to queue ==
                    queue.add(num.toString());
                    // you iterate on expression here .. now back on i ==
                    i = j;
                }
                else if (expression.charAt(i) == 's' || expression.charAt(i) == 'c' || expression.charAt(i) == 't') {
                    StringBuilder num = new StringBuilder();
                    int j = i;
                    two :while (expression.charAt(j) != ')') {
                        num.append(expression.charAt(j));
                        j++;
                        if (j == expression.length()) {
                            break two;
                        }
                    }
                    num.append(")");
                    queue.add(num.toString());
                    i = j;
                }
                // == now its time to push or pop operatons on stack ==
                else {
                    // == make a switch case for operations ==
                    switch(expression.charAt(i)) {
                        // == if it is + ==
                        case '+' :
                            if (!stack.isEmpty()) {
                                // if there are operations with more priority pop them and add them to queue ... until u reach a less priority operation ==
                                while ((stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '^') || stack.peek() == '+') {
                                    queue.add(stack.pop() + "");
                                    // == if stack is empty break while loop ==
                                    if (stack.isEmpty()) {
                                            break;
                                        }
                                    }
                            }
                            // == push + ==
                            stack.push(expression.charAt(i));
                            break;
                        case '-' :
                            if (!stack.isEmpty()) {
                                // if there are operations with more priority pop them and add them to queue ... until u reach a less priority operation ==
                                while (stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '^' || stack.peek() == '-') {
                                    queue.add(stack.pop() + "");
                                    // == if stack is empty break while loop ==
                                    if (stack.isEmpty()) {
                                        break;
                                    }
                                }
                            }
                            // == push - ==
                            stack.push(expression.charAt(i));
                            break;
                        case '*' :
                            // if there are operations with more priority pop them and add them to queue ... until u reach a less priority operation ==
                            if (!stack.isEmpty()) {
                                while (stack.peek() == '^' || stack.peek() == '*') {
                                    queue.add(stack.pop() + "");
                                    // == if stack is empty break while loop ==
                                    if (stack.isEmpty()) {
                                        break;
                                    }
                                }
                            }
                            // == push * ==
                            stack.push(expression.charAt(i));
                            break;
                        case '/' :
                            // if there are operations with more priority pop them and add them to queue ... until u reach a less priority operation ==
                            if (!stack.isEmpty()) {
                                while (stack.peek() == '^' || stack.peek() == '/') {
                                    queue.add(stack.pop() + "");
                                    // == if stack is empty break while loop ==
                                    if (stack.isEmpty()) {
                                        break;
                                    }
                                }
                            }
                            // == push / ==
                            stack.push(expression.charAt(i));
                            break;
                        case '^' :
                            /*if (!stack.isEmpty()) {
                                while (stack.peek() == '^') {
                                    queue.add(stack.pop() + "");
                                    // == if stack is empty break while loop ==
                                    if (stack.isEmpty()) {
                                        break;
                                    }
                                }
                            }*/
                            // == push ^ ==
                            stack.push(expression.charAt(i));
                            break;
                            // == there is a problem in experssion ==
                        default : 
                            System.out.println("there is a problem ...");
                            return new ExpressionsImp("-1");
                    }
                }
                
            }
            // == if char on expression is digit add it in queue ==
            else if (Character.isDigit(expression.charAt(i))) {
                StringBuilder num = new StringBuilder();
                num.append("[");
                int j = i;
                // == find two digit number between [] until u see ] ==
                two :while (Character.isDigit(expression.charAt(j)) || expression.charAt(j) == '.') {
                    num.append(expression.charAt(j));
                    j++;
                    if (expression.length() == j) {
                        break two;
                    }
                }
                num.append("]");
                // == add two digit number to queue ==
                queue.add(num.toString());
                // you iterate on expression here .. now back on i ==
                i = j-1;
            
            }
        }
        // == pop remaining operations in stack and push them into queue ==
        while (!stack.isEmpty()) {
            queue.add(stack.pop() + "");
        }
        // == pop all and add them to result ==
        while (!queue.isEmpty()) {
            result.append(queue.poll());
        }
        
        // == return the result as an ExpressionsImp Object ==
        return new ExpressionsImp(result.toString());
    }
    
    // == post fix result method ==
    // == find the answer of expression ==
    @Override
    public ExpressionsImp evaluator() {
        // == get a post fix mode expression ==
        String postFix = this.postFix().getExpressions() + "";
        // == make a new stack for integers ==
        Stack<Double> stack = new Stack();
        // == iterate on post fix ==
        for (int i = 0; i<postFix.length(); i++) {
            // == get char on index i in postfix ==
            char c = postFix.charAt(i);
            // == if char is a one-digit push it on stack ==
            if (Character.isDigit(c)) {
                stack.push(Double.parseDouble(c + ""));
            }
            // == if it is a two-digit number find it then push it on stack ==
            else if (c == '[') {
                StringBuilder num = new StringBuilder();
                int j = i+1;
                while (true) {
                    c = postFix.charAt(j);
                    if (c == ']') {
                        break;
                    }
                    else {
                        num.append(postFix.charAt(j));
                    }
                    j++;
                }
                stack.push(Double.parseDouble(num.toString()));
                i = j;
            }
            // == get result if you have sin ==
            else if (c == 's') {
                double num = 0;
                for (i = i ;postFix.charAt(i) != ')'; i++) {
                    if (Character.isDigit(postFix.charAt(i))) {
                        num = postFix.charAt(i) - '0';
                    }
                }
                stack.push(Math.sin(num));
            }
            // == get result if you have cos ==
            else if (c == 'c') {
                double num = 0;
                for (i = i ;postFix.charAt(i) != ')'; i++) {
                    if (Character.isDigit(postFix.charAt(i))) {
                        num = postFix.charAt(i) - '0';
                    }
                }
                stack.push(Math.cos(num));
            }
            // == get result if you have tan ==
            else if (c == 't') {
                double num = 0;
                for (i = i ;postFix.charAt(i) != ')'; i++) {
                    if (Character.isDigit(postFix.charAt(i))) {
                        num = postFix.charAt(i) - '0';
                    }
                }
                stack.push(Math.tan(num));
            }
            // == it is an operation so count result and push result on stack for another operations ... ==
            else {
                
                double operand1 = stack.pop();
                double operand2 = stack.pop();
                switch (c) {
                    case '+' :
                        stack.push(operand2 + operand1);
                        break;
                    case '-' :
                        stack.push(operand2 - operand1);
                        break;
                    case '*' :
                        stack.push(operand2 * operand1);
                        break;
                    case '/' :
                        stack.push(operand2 / operand1);
                        break;
                    case '^' :
                        stack.push(Math.pow(operand2, operand1));
                        break;
                    case 's' :
                        
                    default :
                        System.out.println("some thing went wrong ..");
                        return new ExpressionsImp("-1");
                }
            }
        }
        // == reset result string builder for  preventing errors ==
        result.delete(0, result.capacity());
        // == add result from stack ==
        result.append(new DecimalFormat("0.00").format(stack.pop()) + "");
        // == return result as an expressionImp object ==
        return new ExpressionsImp(result.toString());
    }

    @Override
    public ExpressionsImp inFix() {
        
        return new ExpressionsImp(result.toString());
    }
    
    @Override
    public ExpressionsImp postFixVar() {
        String expression = this.expression;
        // == iterate over expression ==
        for (int i = 0; i< expression.length(); i++) {
            // == if character on index i is not a number do some thing ... ==
            if (expression.charAt(i) != 'x') {
                // == if it is ( push it on stack ==
                if (expression.charAt(i) == '(') {
                    stack.push(expression.charAt(i));
                }
                // == if it is ) pop operations those are in stack until the operation be ( ==
                else if (expression.charAt(i) == ')') {
                    while (stack.peek() != '(') {
                        queue.add(stack.pop() + "");
                    }
                    // == delete ( ==
                    stack.pop();
                }
                else if (expression.charAt(i) == 's' || expression.charAt(i) == 'c' || expression.charAt(i) == 't') {
                    StringBuilder num = new StringBuilder();
                    int j = i;
                    two :while (expression.charAt(j) != ')') {
                        num.append(expression.charAt(j));
                        j++;
                        if (j == expression.length()) {
                            break two;
                        }
                    }
                    num.append(")");
                    queue.add(num.toString());
                    i = j;
                }
                // == now its time to push or pop operatons on stack ==
                else {
                    // == make a switch case for operations ==
                    switch(expression.charAt(i)) {
                        // == if it is + ==
                        case '+' :
                            if (!stack.isEmpty()) {
                                // if there are operations with more priority pop them and add them to queue ... until u reach a less priority operation ==
                                while ((stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '^')) {
                                    queue.add(stack.pop() + "");
                                    // == if stack is empty break while loop ==
                                    if (stack.isEmpty()) {
                                            break;
                                        }
                                    }
                            }
                            // == push + ==
                            stack.push(expression.charAt(i));
                            break;
                        case '-' :
                            if (!stack.isEmpty()) {
                                // if there are operations with more priority pop them and add them to queue ... until u reach a less priority operation ==
                                while ((stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '^')) {
                                    queue.add(stack.pop() + "");
                                    // == if stack is empty break while loop ==
                                    if (stack.isEmpty()) {
                                        break;
                                    }
                                }
                            }
                            // == push - ==
                            stack.push(expression.charAt(i));
                            break;
                        case '*' :
                            // if there are operations with more priority pop them and add them to queue ... until u reach a less priority operation ==
                            if (!stack.isEmpty()) {
                                while (stack.peek() == '^') {
                                    queue.add(stack.pop() + "");
                                    // == if stack is empty break while loop ==
                                    if (stack.isEmpty()) {
                                        break;
                                    }
                                }
                            }
                            // == push * ==
                            stack.push(expression.charAt(i));
                            break;
                        case '/' :
                            // if there are operations with more priority pop them and add them to queue ... until u reach a less priority operation ==
                            if (!stack.isEmpty()) {
                                while (stack.peek() == '^' && !stack.isEmpty()) {
                                    queue.add(stack.pop() + "");
                                    // == if stack is empty break while loop ==
                                    if (stack.isEmpty()) {
                                        break;
                                    }
                                }
                            }
                            // == push / ==
                            stack.push(expression.charAt(i));
                            break;
                        case '^' :
                            // == push ^ ==
                            stack.push(expression.charAt(i));
                            break;
                            // == there is a problem in experssion ==
                        default : 
                            System.out.println("there is a problem ...");
                            return new ExpressionsImp("-1");
                    }
                }
                
            }
            // == if char on expression is digit add it in queue ==
            else if (expression.charAt(i) == 'x') {
                queue.add(expression.charAt(i) + "");
            }
        }
        // == pop remaining operations in stack and push them into queue ==
        while (!stack.isEmpty()) {
            queue.add(stack.pop() + "");
        }
        // == pop all and add them to result ==
        while (!queue.isEmpty()) {
            result.append(queue.poll());
        }
        
        // == return the result as an ExpressionsImp Object ==
        return new ExpressionsImp(result.toString());
    }
    
    @Override
    public void evaluatorVar() {
        // == get a post fix mode expression ==
        String postFix = this.postFixVar().getExpressions();
        // == make a new stack for integers ==
        Stack<Double> stack = new Stack();
        // == decimal format class ==
        DecimalFormat df = new DecimalFormat("0.000");
        int counter = 0;
        // == iterate on post fix ==
        one :for (double k = -499.99; k<horizontal.length; k = k + 0.01){
            // == make indexes for arrays ==
            if (counter == 100000) {
                break one;
            }
            // == add horizontal points ==
            horizontal[counter] = k;
            for (int i = 0; i<postFix.length(); i++) {
                // == get char on index i in postfix ==;.=.=]/
                char c = postFix.charAt(i);
                // == if char is a one-digit push it on stack ==
                if (c == 'x') {
                    stack.push(k);
                }
                else if (Character.isDigit(c)) {
                    stack.push((double) (c-'0'));
                }
                else if (c == 's') {
                    stack.push(Math.sin(k));
                    i=i+5;
                }
                else if (c == 'c') {
                    stack.push(Math.cos(k));
                    i=i+5;
                }
                else if (c == 't') {
                    stack.push(Math.tan(k));
                    i = i+5;
                }
                // == it is an operation so count result and push result on stack for another operations ... ==
                else {
                    double operand1 = stack.pop();
                    double operand2 = stack.pop();
                    switch (c) {
                        case '+' :
                            stack.push(Double.parseDouble(df.format(operand2 + operand1)));
                            break;
                        case '-' :
                            stack.push(Double.parseDouble(df.format(operand2 - operand1)));
                            break;
                        case '*' :
                            stack.push(Double.parseDouble(df.format(operand2 * operand1)));
                            break;
                        case '/' :
                            if (k == 0) {
                                continue one;
                            }
                            //System.out.println(operand2/operand1);x
                            
                                if (Double.isInfinite(operand2/operand1)) {
                                    inf.add(k);
                                    stack.push( (double) 2000000000);
                                    System.out.println();
                                }
                                else {
                                    stack.push(Double.parseDouble(df.format(operand2 / operand1)));
                                }
                            
                            break;
                        case '^' :
                            stack.push(Math.pow(operand2, operand1));
                            break;
                        default :
                            System.out.println("some thing went wrong ..");
                            return;
                    } // end switch
                }
            } // end for i
            // == add vertical points ==
            vertical[counter] = stack.pop();
            //System.out.println(counter);
            
            counter++;
        } // end for k
        
        new Diagram(horizontal , vertical).setVisible(true);
    }
    
    

    
}
