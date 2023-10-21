package S1;



public class S1q13 {
    
    static void hanoi(int n, char s, char d, char a) {
        if (n==1) {
            System.out.println("disk 1 from " + s + " to " + d);
            return;
        }
        hanoi(n-1,s,a,d);
        System.out.println("disk " + n + " from " + s + " to " + d);
        hanoi(n-1,a,d,s);
    }
    
    public static void main(String[] args) {
        hanoi(3,'S','D','A');
    }
}
