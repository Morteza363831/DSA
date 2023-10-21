package S1;



public class S1q10 {
    
    
    static double sum;
    static double fs(int n) {
        if (n == 0) return sum;
        sum += 1/fact(n);
        return fs(n-1);
    }
    
    static double fact(int n) {
        if (n == 0) return 1;
        return n * fact(n-1);
    }
    public static void main(String[] args) {
    
        System.out.print(fs(3));
        
        
    }
}
