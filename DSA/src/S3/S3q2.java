package S3;

import java.util.Scanner;

public class S3q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] n = new int[input.nextInt()];
        int[] r = new int[input.nextInt()];
        int[] n_r = new int[n.length-r.length];
        n[0] = 1;
        r[0] = 1;
        n_r[0] = 1;
        for (int i = 1; i<n.length; i++) {
            n[i] = n[i-1] * (i+1);
        }
        for (int i = 1; i<r.length; i++) {
            r[i] = r[i-1] * (i+1);
        }
        for (int i = 1; i<n_r.length; i++) {
            n_r[i] = n_r[i-1] * (i+1);
        }
        System.out.print(n[n.length-1]/(r[r.length-1] * n_r[n_r.length-1]));
    }
}
