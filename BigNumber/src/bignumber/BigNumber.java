package bignumber;

import java.util.Scanner;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
public class BigNumber {
    // == constants ==
    
    int[] arr1;
    List<Integer> result= new ArrayList<>();
    List<Integer> indexes= new ArrayList<>();
    int temp= 0;
    int sign = 0;
    String copy;
    String number = "0";
    boolean flag;
   
    // == constructor ==
    public BigNumber(String num) {
        this.number = num;
        sign = 0;
        flag = false;
    }
    
    public void sign(BigNumber other) {
        if (this.number.charAt(0) == '-') {
            this.number = this.number.substring(1);
            this.sign = 9;
        }
        else if (this.number.charAt(0) == '+'){
            this.number = this.number.substring(1);
            this.sign = 0;
        }
        if (other.number.charAt(0) == '-') {
            other.number = other.number.substring(1);
            other.sign = 9;
        }
        else if (other.number.charAt(0) == '+'){
            other.number = other.number.substring(1);
            other.sign = 0;
        }
    } 
    public void numberLength(BigNumber other) {
         // == init constants ==
        
        this.number = leadingZero(this.number);
        other.number = leadingZero(other.number);
        
        if (this.number.length() > other.number.length()) {
            // == we need same length ==
            other.number = "0".repeat(this.number.length()-other.number.length()) + other.number;
            // == first input number is greater ==
            flag = true; 
        }
        else if (this.number.length() == other.number.length()) {
            // == first input number is greater ==
            flag = true;
            for (int i = 0; i<this.number.length(); i++) {
                if (this.number.charAt(i) > other.number.charAt(i)) {
                    flag = true;
                    break;
                }
                else if (this.number.charAt(i) == other.number.charAt(i)) {
                    continue;
                }
                // == second number is greater ==
                else {
                    // == swap numbers ==
                    flag = false;
                    copy = this.number;
                    this.number = other.number;
                    other.number = copy;
                    break;
                }
            }
        }
        // == number2 is greater ==
        else {
            this.number = "0".repeat(other.number.length()-this.number.length()) + this.number;
            // == swap numbers ==
            flag = false; // second input number is greater
            copy = this.number;
            this.number = other.number;
            other.number = copy;
        }
        
        
        
    }
    
    // == sum method ==
    public BigNumber sum(BigNumber other) {
        sign(other);
        numberLength(other);
        StringBuilder sum = new StringBuilder();
        // == reset result list and temp ==
        result.removeAll(result);
        temp = 0;
        // == sum of to big number ==
        for (int i = this.number.length()-1; i>=0; i--) {
            // == it continues until arr2 indexes end ! ==
            if (i >= 0) {
                result.add((this.number.charAt(i)+other.number.charAt(i)+temp - '0' - '0')%10);
                temp = (this.number.charAt(i)+other.number.charAt(i)+ temp - '0' - '0')/10;
                if (i == 0) {
                    result.add((this.number.charAt(i)+other.number.charAt(i) + temp - '0' - '0')/10);
                }
            }
            // == it continues until arr 1 indexes end
            else {
                result.add(this.number.charAt(i) + temp - '0');
                temp = 0;
            }
        }
        
        // == add data on result list to sumResult string ! ==
        if (this.sign + other.sign == 18) {
                sum.append("-");
        }
        
        Collections.reverse(result);
        for (int digit : result) {
            sum.append(digit + "");
        }
        
        this.number = leadingZero(this.number);
        other.number = leadingZero(other.number);
        // == return sum ==
        return new BigNumber(leadingZero(sum.toString()));
    }
    
    
    // minus method ==
    public BigNumber subtract(BigNumber other) {
        sign(other);
        numberLength(other);
        // == create string builder to return minus ==
        StringBuilder minus = new StringBuilder();
        // == reset result list ==
        result.removeAll(result);
        int borrow = 0;
        // == find minus of to big numbers ==
        for (int i = this.number.length()-1; i >= 0; i--) {
            int diff = (this.number.charAt(i) - borrow - other.number.charAt(i));
            if (diff < 0) {
                diff += 10;
                if (i == 0 && diff == -1){
                    diff = 0;
                }
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.add(0, diff);
        }
        
        // == add data on result list ==
        if (this.sign + other.sign == 18) {
            if (flag) {
                minus.append("-");
            }
            else {
            }
        }
        else if (this.sign+other.sign == 0) {
            if (flag) {
            }
            else {
                minus.append("-");
            }
        }
        if (other.sign == 9 && this.sign == 0) {
            minus.append(this.sum(other).number);
            return new BigNumber(minus.toString());
        }
        else if (other.sign == 0 && this.sign == 9) {
            minus.append("-");
            minus.append(this.sum(other).number);
            return new BigNumber(minus.toString());
        }
        
        
        for (int digit : result) {
            minus.append(digit + "");
        }
        
        if (!flag) {
            copy = other.number;
            other.number = this.number;
            this.number = copy;
        }
        this.number = leadingZero(this.number);
        other.number = leadingZero(other.number);
        return new BigNumber(leadingZero(minus.toString()));
    }
    
     
    public BigNumber mult(BigNumber other) {
        sign(other);
        numberLength(other);
        // == it return multiply of two big number ==
        StringBuilder multiply = new StringBuilder();
        // == reset result list ==
        result.removeAll(result);
        // == get numbers length ==
        int len1 = this.number.length();
        int len2 = this.number.length();
        int[] product = new int[len1 + len2];

        // == Multiply each digit and store the result in the product array ==
        for (int i = len1 - 1; i >= 0; i--) {
            int carry = 0;
            int n1 = this.number.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int n2 = other.number.charAt(j) - '0';
                int sum = n1 * n2 + product[i + j + 1] + carry;
                product[i + j + 1] = sum % 10;
                carry = sum / 10;
            }
            product[i] += carry;
        }

        // == Convert the product array to a list of integers ==
        for (int digit : product) {
            result.add(digit);
        }

        // == Remove leading zeros ==
        while (!result.isEmpty() && result.get(0) == 0) {
            result.remove(0);
        }

        // ==  add data from result list to multiply string ==
        if (this.sign + other.sign == 0) {
            
        }
        else if (this.sign + other.sign == 18){
        }
        else{
            multiply.append("-");
        }
        
        for (int digit : result) {
            multiply.append(digit + "");
        }
        other.number = leadingZero(other.number);
        // == return multiply string as result ==
        return new BigNumber(multiply.toString());
    }
    
    
    private boolean isNegative(BigNumber other) {
        if (this.subtract(other).number.charAt(0) == '-') {
            return true;
        }
        else {
            return false;
        }
    }
   
    public BigNumber divide(BigNumber other) {
        sign(other);
        int tempSign1 = this.sign;
        int tempSign2 = other.sign;
        this.sign = 0;
        other.sign = 0;
        // == result ==
        BigNumber quotient = new BigNumber("0");
        // == copy of num one ==
        BigNumber num1 = new BigNumber(this.number);
        int counter = 0;
        // == diff between of numbers lengthes ==
        int diff = num1.number.length() - other.number.length() - 1;
        BigNumber temp = new BigNumber(other.number + "0".repeat(diff));
        // == delete left zeros ==
        temp.number = leadingZero(temp.number);
        // == divide while loop ==
        while (true) {
            num1.number = num1.subtract(temp).number;
            counter++;
            // == change temp and add counter res to quotient ==
            if (num1.isNegative(temp)) {
                BigNumber res = new BigNumber(new BigNumber(counter + "").mult(new BigNumber("1" + "0".repeat(diff))).number);
                quotient.number = quotient.sum(res).number;
                counter = 0;
                if (num1.number.length() <= other.number.length()) {
                    diff = 0;
                    temp = other;
                    temp.number = leadingZero(temp.number);
                }
                else {
                    diff = num1.number.length() - other.number.length() - 1;
                    temp = new BigNumber(other.number + "0".repeat(diff));
                    temp.number = leadingZero(temp.number);
                }
            }
            if (num1.isNegative(other)) {
                break;
            }
        }
        if (tempSign1 + tempSign2 == 0) {
            this.sign = tempSign1;
            other.sign = tempSign2;
            return quotient;
        }
        else if (tempSign1 + tempSign2 == 18){
            this.sign = tempSign1;
            other.sign = tempSign2;
            return quotient;
        }
        else{
            this.sign = tempSign1;
            other.sign = tempSign2;
            return new BigNumber("-" + quotient.number);
        }
    }
    
    public BigNumber pow (int n) {
        BigNumber pow = new BigNumber(n + "");
        BigNumber firstNum = new BigNumber(this.number);
        BigNumber secondNum;
        int quotient = n/10;
        int remaining = n%10;
        if (n >= 10) {
            for (int i = 1; i<10; i++) {
                this.number = this.mult(firstNum).number;
            }
            secondNum = new BigNumber(this.number);
            for (int i = 1; i<quotient; i++) {
                this.number = this.mult(secondNum).number;
            }
            for (int i = 0; i<remaining; i++) {
                this.number = this.mult(firstNum).number;
            }
            return new BigNumber(this.number);
        }
        else if (n > 0 && n<10){
            for (int i = 1; i<remaining; i++) {
                this.number = this.mult(firstNum).number;
            }
            return new BigNumber(this.number);
        }
        else {
            return new BigNumber("0");
        }

    }
    
    public String shiftR(int n) {
        if (this.sign == 9) {
            this.number = "-" + this.number;
        }
        
        if (n > this.number.length()) {
            return "n must be less than the number length !";
        }
        else if (n <this.number.length()){
        this.number = this.number.substring(0,this.number.length()-n);
        return this.number;
        }
        else {
            return "0";
        }
        
    }
    public String shiftL(int n) {
        this.number = this.number + "0".repeat(n);
        if (this.sign == 9) {
            this.number = "-" + this.number;
        }
        return this.number;
    }
    
    public String inc() {
        BigNumber inc = new BigNumber("-1");
        this.number = this.subtract(inc).number;
        return this.number;
    }
    public String dec() {
        BigNumber dec = new BigNumber("1");
        this.number = this.subtract(dec).number;
        return this.number;
        
    }
    
    private String leadingZero(String str) {
        int index = 0;
        char sign = 0;
        if (str.charAt(0) == '-') {
            sign = str.charAt(0);
            str = str.substring(1);
            for (int i = 0; i< str.length() ; i++) {
                if (str.charAt(i) != '0') {
                    index = i;
                    break;
                }
            }
            str = sign + str.substring(index);
        }
        else {
            for (int i = 0; i< str.length() ; i++) {
                if (str.charAt(i) != '0') {
                    index = i;
                    break;
                }
            }
            str = str.substring(index);
        }
        
        return str;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s1 = input.nextLine();
        String s2 = input.nextLine();
        BigNumber num1 = new BigNumber(s1);
        BigNumber num2= new BigNumber(s2);
        int action = input.nextInt();

        switch(action) {
            case 1 : 
                System.out.println(num1.sum(num2).number);
                break;
            case 2 :
                System.out.println(num1.subtract(num2).number);
                break;
            case 3 :
                System.out.println(num1.mult(num2).number);
                break;
            case 4 :
                System.out.println(num1.divide(num2).number);
                break;
            case 5 :
                System.out.println(num1.pow(1000).number);
                break;
            case 6 :
                System.out.println(num1.shiftL(5));
                break;
            case 7 : 
                System.out.println(num1.shiftR(5));
                break;
            default :
                System.out.println("please choose an operand !");
                break;
        }
        
        BigInteger n1 = new BigInteger(s1);
        BigInteger n2 = new BigInteger(s2);
        System.out.println(n1.divide(n2));
        
    }
    
}
