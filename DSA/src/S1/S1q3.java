package S1;




public class S1q3 {
    
    static int temp = 0;
    
   
    static int[] reverse(int[] n, int i, int j) {
        if (i == j) return n;
        temp = n[i];
        n[i] = n[j];
        n[j] = temp;
        return reverse(n,i+1,j-1);
    }
    
    public static void main(String[] args) {
        
        int[] n = {1,3,4,7,9};
        int[] reversed = reverse(n,0,n.length-1);
        for (int i =0 ; i<reversed.length; i++) {
            System.out.print(reversed[i] + " ");
        }
        
    }
    
}
