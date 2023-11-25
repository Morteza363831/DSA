package S3;

import java.util.Scanner;

public class S3q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] fib = new int[n];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i<n ; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        System.out.print(fib[n-1]);
    }
    
}
