package S1;


public class S1q18 {
    
    static boolean dup(String s, int l) {
        if (l%2 != 0) return false;
        if (l == 0) return true;
        else {
            s= (String) s.subSequence(1, l/2);
            return dup(s,s.length());
        }
    }
    
    public static void main(String[] args) {
        
        System.out.println(dup("alilialili", "alilialili".length()));
        
        
    }
}
