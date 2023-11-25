package S3;

import java.util.Scanner;

public class S3q7 {
    int counter = 0;
    public boolean transpose(int[][] a , int[][] b) {
        for (int i = 0; i< a.length ; i++) {
            for (int j = 0; j< a.length; j++) {
                if (a[i][j] == b[j][i]) {
                    counter++;
                }
            }
        }
        if (counter == a.length*a.length) {
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) {
        int[][] a = {
            {1, 2, 3},
            {4, 5, 6,},
            {7, 8, 9}
        };
        int[][] b = {
            {1, 4, 7},
            {2, 5, 8,},
            {3, 6, 9}
        };
        S3q7 q7 = new S3q7();
        System.out.print(q7.transpose(a, b));
    }
}
