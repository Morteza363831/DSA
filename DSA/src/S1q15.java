
import java.util.Arrays;

public class S1q15 {
    static int N = 8;

    static boolean isSafe(int row, int col, int[] positions) {
        for (int i = 0; i < row; i++) {
            int diff = Math.abs(positions[i] - col);
            if (diff == 0 || diff == row - i) {
                return false;
            }
        }
        return true;
    }

    static void solve(int row, int[] positions) {
        if (row == N) {
            System.out.println(Arrays.toString(positions));
            return;
        }
        for (int col = 0; col < N; col++) {
            if (isSafe(row, col, positions)) {
                positions[row] = col;
                solve(row + 1, positions);
            }
        }
    }

    public static void main(String[] args) {
        int[] positions = new int[N];
        solve(0, positions);
    }
}
