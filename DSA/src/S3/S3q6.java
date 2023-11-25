package S3;

import java.util.Scanner;

public class S3q6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] row = new int[n];
        int[] column;
        int k = -1;
        for (int i = 1; i<=n; i++) {
            column = new int[i];
            for (int j = 1; j<column.length-1; j++) {
                column[0] = 1;
                column[column.length-1] = 1;
                if (j<=(i/2)) {
                column[j] = 1 + k + i-2;
                    
                }
            }
            for (int j = 0; j<column.length; j++) {
                System.out.println(column[j]);
            }
            k+=1;
        }
    }
    
}
