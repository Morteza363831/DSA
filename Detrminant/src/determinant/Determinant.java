package determinant;
import bignumber.BigNumber;
public interface Determinant {
    // recursive methods 
    public void getChild(double[][] matrix,double[][] temp, int x, int y,int n);
    
    public double laplase(double[][] matrix, int n);
    
    public double omid(double[][] matrix, int n);
    
    public double gaussian(double[][] matrix, int n);
}
