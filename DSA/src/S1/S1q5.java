package S1;



import java.util.ArrayList;
import java.util.List;

public class S1q5 {
    
    static int max;
    static int maximum(List<Integer> n , int i) {
        if (n.size() == 1) return n.get(0);
        if (n.get(i) <= n.get(i-1)) {
            n.remove(i);
        }
        else {
            n.remove(i-1);
        }
        return maximum(n, n.size()-1);
    }
    
    public static void main(String[] args) {
        List<Integer> n = new ArrayList<>();
        n.add(1);
        n.add(2);
        n.add(5);
        n.add(7);
        n.add(4);
        n.add(9);
        n.add(5);
        System.out.print(maximum(n,n.size()-1));
    }
    
}
