package determinant;

import java.text.DecimalFormat;

public class DeterminantImp implements Determinant{
    // == decimal format object ==
    DecimalFormat df;
    // == the size of rows and coulmns
    int N;
    
    // == init constants in constructor ==
    public DeterminantImp() {
        df = new DecimalFormat("0.00");
    }
    
    // == this method will make a new matrix without a specific row and coulmn ==
    @Override
    public void getChild(double[][] matrix, double[][] temp, int x, int y, int n) {
        int i = 0;
        int j = 0;
        // == moving on parent matrix and copy choosen values to child matrix (temp) ==
        for (int row = 0;row<n; row++) {
            for (int column = 0; column < n; column++) {
                // == skip specific row and column ==
                if (row != x && column != y) {
                    // == copy values on temp and make new matrix ==
                    temp[i][j] = matrix[row][column];
                    j++;
                    if (j == n-1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    // == baries (laplase) way to calculate determinant of a matrix ==
    @Override
    public double laplase(double[][] matrix, int n) {
        // == result ==
        double determinant = 0;
        // == return type to make a recursive method ==
        if (n == 1) {
            return matrix[0][0];
        }
        // == make smaller matrices to find the parent answer ==
        double[][] temp = new double[N][N];
        int sign = 1;
        for (int i = 0; i<n; i++) {
            // == find child matrices .. ==
            getChild(matrix,temp,0,i,n);
            // == add new answer to result ==
            determinant+= sign * matrix[0][i] * laplase(temp,n-1);
            // == changer sign one by one ==
            sign = -sign;
        }
        
        
        // == return result to user ==
        return Double.parseDouble(df.format(determinant));
    }
    
    @Override
    public double omid(double[][] matrix, int n) {
        // == tester will show the divider is zero or no ==
        int tester = 0;
        // == result ==
        double determinant = 0;
        // == init return types to make method recursive ==
        if (n == 2) {
            return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
        }
        else if (n == 1) {
            return matrix[0][0];
        }
         
        // == find divider with recursive functions and child matrices ==
        double[][] temp1 = new double[n-2][n-2];
        int x = 0;
        int y = 0;
        // == set child matrix ==
        for (int i = 1; i<matrix.length-1; i++) {
            for (int j = 1; j<matrix.length-1; j++) {
                temp1[x][y]=matrix[i][j];
                y++;
                if (y == n-2) {
                    y = 0;
                    x++;
                }
            }
        }
        // == call method because divider is a matrix and it must calculate with omid way ==
        double e = omid(temp1,n-2);
        
        // == make temps for 4 operands in omid way ==
        double[][] temp2 = new double[n-1][n-1];
        double[][] temp3 = new double[n-1][n-1];
        double[][] temp4 = new double[n-1][n-1];
        double[][] temp5 = new double[n-1][n-1];
        
        // == call recursive methods ==
        getChild(matrix,temp2,0,0,n);
        double a = omid(temp2,n-1);
        getChild(matrix,temp3,0,n-1,n);
        double b = omid(temp3,n-1);
        getChild(matrix,temp4,n-1,0,n);
        double c = omid(temp4,n-1);
        getChild(matrix,temp5,n-1,n-1,n);
        double d = omid(temp5,n-1);
        // == if tester is 1 it means there is a 0 in dividers ==
        if (e == 0) {
            throw new NullPointerException("cannot divide with 0");
        }
        else {
            if (tester == 1) {
            tester = 0;
            throw new NullPointerException("cannot divide with 0");
            }else {
                // == return result ==
                determinant = (a*d - b*c)/e;
                return Double.parseDouble(df.format(determinant));
            }
        }
        
        // == if tester is 0 it means there is no zero ==
        
    }
    // == guassion way to calculate determinant of a matrix ==
    @Override
    public double gaussian(double[][] matrix, int n) {
        // == result ==
        double determinant = 1;
        // == sign for swaping time ==
        double sign = 1;
        // == check matrix[0][0] is zero == 
        if (matrix[0][0] == 0) {
            int x = 0;
            for (int i = 0; i<n; i++) {
                if (matrix[i][0] != 0) {
                    x = i;
                }
            }
            // == swap rows ==
            for (int j = 0; j<n; j++) {
                double copy = matrix[0][j];
                matrix[0][j] = matrix[x][j];
                matrix[x][j] = copy;
                sign = -1;
            }
        }
        
        int x = 0;
        int y = 0;
        // == save divisions ==
        double division = 0;
        // == make a gaussian matrix ==
        while (y < n) {
            for (int i = x; i<n-1; i++) {
                if (matrix[i+1][y] != 0) {
                    division = matrix[i+1][y];
                    for (int j = y; j<n; j++) {
                        matrix[i+1][j] = matrix[i+1][j] - (matrix[x][j] * (division/matrix[x][y]));
                    }
                }
                
            }
            x++;
            y++;
        }
        // == calculate result ==
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (i == j) {
                   determinant *= matrix[i][j]; 
                }
            }
        }
        // == return result ==
        determinant = sign * determinant;
        sign = 1;
        return Double.parseDouble(df.format(determinant));
    }

    /*public static void main(String[] args) {
        DeterminantImp di = new DeterminantImp();
        /*double[][] matrix = {
            { 1, 0, 2, -1 },
            { 3, 1, 1, 5 },
            { 2, 1, 4, -3 },
            { 1, 0, 5, 0 } 
        };
        double[][] matrix = 
        {
            {1, 8, 3, 5, 1},
            {4, 2, 1, 5, 6},
            {7, 4, 6, 5, 3},
            {2, 2, 2, 2, 2},
            {1, 2, 3, 4, 5}
        };
        double[][] matrix = 
        {
            {5,9,7},
            {8,12,13},
            {-1,15,4}
        };
        double[][] matrix = 
        {
            {0,2,3},
            {0,5,6},
            {7,8,9}
        };
        di.N = matrix.length;
        System.out.println(di.omid(matrix,di.N));
        System.out.println(di.laplase(matrix,di.N));
        System.out.println(di.gaussian(matrix,di.N));
    }*/
    
    

    
}
