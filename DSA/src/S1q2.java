
public class S1q2 {
    
    static int sum = 0;
    
    static int average(int[] n , int i) {
        if (i == n.length) return (sum/n.length);
        sum += n[i];
        return average(n , i+1);
        
    }
    
    public static void main(String[] args) {
        
        int[] n = {2,5,4,7,8,10,6};
        System.out.print(average(n,0));
        
    }
}
