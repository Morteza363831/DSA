public class S1q11 {

    static void exchange(int n, int c2, int c5, int c10) {
        if (n>=0) {
            if (n == 0) {
                System.out.println("c2 : " + c2 + " c5 : " + c5 + " c10 : " + c10);
            }
            else {
                exchange(n-2,c2+1,c5,c10);
                exchange(n-5,c2,c5+1,c10);
                exchange(n-10,c2,c5,c10+1);
            }
        }
    }
    
    public static void main(String[] args) {
        exchange(20,0,0,0);
    }
    
}
