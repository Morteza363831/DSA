public class S1q8 {
    
    static void gt(int[] binary, int n) {
        if (n == 0) {
            for (int b : binary) {
                System.out.print(b);
            }
        System.out.println();
        }
        else {
            binary[n-1] = 0;
            gt(binary,n-1);
            binary[n-1] = 1;
            gt(binary,n-1);
        }
        
        
        
    }
    
    public static void main(String[] args) {
        int n = 4;
        int[] binary = new int[n];
        gt(binary,n);
        
    }
}
