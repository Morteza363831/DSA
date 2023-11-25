package S3;

import java.util.Scanner;

public class S3q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
        int[][] matrix= new int[n][n];
        
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        
        for (int i = 0; i<n; i++) {
            matrix[i][i] ++;
        }
        for (int i = n-1; i>=0 ; i--) {
                matrix[n-1-i][i]--;
            
            
        }
        for (int i = 0; i<n ; i++) {
            for (int j = 0; j<n; j++) {
                if ((i == 0 || i == n-1) && (j !=0 && j != n-1)){
                    if (j>i) {
                    matrix[i][j]+=2;
                    }
                    else if (i>j) {
                        matrix[i][j] -=2;
                    }
                }
            }
            
        }
        for (int i = 0; i<n ; i++) {
            for (int j = 0; j<n; j++) {
                if ((i != 0 && i != n-1) && (j ==0 || j == n-1)){
                    if (j>i) {
                        matrix[i][j] -=3;
                    }
                    else if (i>j) {
                        matrix[i][j] +=3;
                    }
                }
            }
            
        }
        
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
    }
}
