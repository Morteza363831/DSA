package S1;



public class S1q9 {
    
    static int sum;
    static int fs(int n) {
        if (n == 0) return sum;
        sum += fact(n);
        return fs(n-1);
    }
    
    static int fact(int n) {
        if (n == 0) return 1;
        return n * fact(n-1);
    }
    public static void main(String[] args) {
    
        System.out.print(fs(3));
        
        
    }
}
