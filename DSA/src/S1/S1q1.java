package S1;





public class S1q1 {
    
    static int counter = 1;
    
    static int divide(int a, int b) {
        if (a-b == 0) return counter;
        counter++;
        return divide(a-b, b);
    }
    
        public static void main(String[] args) {
            
            System.out.print(divide(40,5));
            
        }
}
