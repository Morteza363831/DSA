package bignumber;

import java.util.Scanner;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class BigNumber {
    // == constants ==
    static Scanner input = new Scanner(System.in);
    static BigInteger num1 = new BigInteger(input.nextLine()); 
    static BigInteger num2 = new BigInteger(input.nextLine());
    static String s1 = num1.toString();
    static String s2= num2.toString();
    static int[] arr1= new int[s1.length()];
    static int[] arr2= new int[s2.length()];
    static List<Integer> result= new ArrayList<>();
    static List<Integer> indexes= new ArrayList<>();
    static int temp= 0;
    
    // == constructor ==
    public BigNumber() {
        // == convert big numbers to arrays ==
        for (int i = 0; i<s1.length(); i++) {
            arr1[i] = Integer.parseInt(s1.charAt(i) + "");
        }
        for (int i = 0; i<s2.length(); i++) {
            arr2[i] = Integer.parseInt(s2.charAt(i) + "");
        }
    }
    
    // == sum method ==
    public static void sum(BigInteger num1, BigInteger num2) {
        temp = 0;
        for (int i = arr1.length-1; i>=0; i--) {
            result.add((arr1[i]+arr2[i]+temp)%10);
            temp = (arr1[i]+arr2[i]+ temp)/10;
            if (i == 0) {
                result.add((arr1[i]+arr2[i])/10);
            }
        }
        Collections.reverse(result);
        for (int digit : result) {
            System.out.print(digit);
        }
        System.out.println();
    }
    
    
    // minus method ==
    public static void minus(BigInteger num1, BigInteger num2) {
        result.removeAll(result);
        int borrow = 0;

        for (int i = s1.length() - 1; i >= 0; i--) {
            int diff = (s1.charAt(i)) - borrow - (s2.charAt(i));
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.add(0, diff);
        }
        
        for (int digit : result) {
            System.out.print(digit);
        }
        System.out.println();
    }
    
     // == multiply method ==
    public static void multiply(BigInteger num1, BigInteger num2) {
        result.removeAll(result);
        for (int i = arr1.length-1; i>=0; i--) {
            indexes.add(arr1.length-i-1, arr2[i]);
            
            while(!num1.equals(0)) {
                indexes.set(arr1.length-i-1, indexes.get(arr1.length-i-1) + arr2[i]);
                num1 = num1.subtract(BigInteger.valueOf(1));
            }
        }
        int count = 0;
        while (true) {
            if (count <=indexes.size()-1) {
                result.add((indexes.get(count)+temp)%10);
                temp = (indexes.get(count)+temp)/10;
                count++;
            }
            else{
                result.add(temp%10);
                temp = (temp)/10;
                if (temp/10 <10) {
                    result.add(temp);
                break;
                }
            } 
        } 
        Collections.reverse(result);
        for (int i = 0; i<result.size(); i++) {
            System.out.print(result.get(i));
        }
        System.out.println();
    }
    
    public static void multiplySecondWay(BigInteger num1, BigInteger num2) {
        result.removeAll(result);
        int len1 = s1.length();
        int len2 = s2.length();
        int[] product = new int[len1 + len2];

        // Multiply each digit and store the result in the product array
        for (int i = len1 - 1; i >= 0; i--) {
            int carry = 0;
            int n1 = s1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int n2 = s2.charAt(j) - '0';
                int sum = n1 * n2 + product[i + j + 1] + carry;
                product[i + j + 1] = sum % 10;
                carry = sum / 10;
            }
            product[i] += carry;
        }

        // Convert the product array to a list of integers
        for (int digit : product) {
            result.add(digit);
        }

        // Remove leading zeros
        while (!result.isEmpty() && result.get(0) == 0) {
            result.remove(0);
        }

        // Print the result
        for (int digit : result) {
            System.out.print(digit);
        }
        System.out.println();
    }
    
    public static void divide(BigInteger num1 , BigInteger num2) {
        result.removeAll(result);
        temp = 0;
        result= new ArrayList<>(Collections.nCopies(num1.toString().length() + num2.toString().length() + 2, 0));
        
        
        while (true) {
            if (num1.compareTo(num2) < 0) {
                break;
            }
            else {
                result.set(0, result.get(0)+1);
            
                for (int i = 0; i<result.size(); i++) { // inner for
                    if (result.get(i) >= 10) {
                        result.set(i, 0);
                            result.set(i+1, result.get(i+1)+1);
                    }
                }// inner for
                num1 = num1.subtract(num2);
            }             
        }
        
        Collections.reverse(result);
        for (int digit : result) {
            System.out.print(digit);
        }
        System.out.println();
    }
    
    

    public static void main(String[] args) {
        BigNumber bn = new BigNumber();
        
        // actions with big integer class methods !
        
        // == sum ==
        System.out.println(num1.add(num2));
        // == minus ==
        System.out.println(num1.subtract(num2));
        // == multiply ==
        System.out.println(num1.multiply(num2));
        // == divide ==
        System.out.println(num1.divide(num2));
        
        
        //sum second way
        sum(num1,num2);
        // == minus second way
        minus(num1,num2);
        //multiply
        //multiply(num1,num2);
        multiplySecondWay(num1,num2);
        //divide second way
        divide(num1,num2);
        
    }
    
}
