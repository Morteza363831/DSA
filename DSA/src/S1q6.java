public class S1q6 {
    int sum;
    int multi(int a, int b) {
        if (b == 0) {
            return sum;
        }
        sum += a;
        return multi(a,b-1);
    }
    
    
    public static void main(String[] args) {
        S1q6 sq = new S1q6();
        System.out.print(sq.multi(10, 10));
    }
}
