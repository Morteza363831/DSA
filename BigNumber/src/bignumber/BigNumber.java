package bignumber;

import java.util.Scanner;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
public class BigNumber {
    // == constants ==
    static Scanner input = new Scanner(System.in);
    static int[] arr1;
    static List<Integer> result= new ArrayList<>();
    static List<Integer> indexes= new ArrayList<>();
    static int temp= 0;
    static int sign1 = 0;
    static int sign2 = 0;
    
    
    static byte[] copy;
    
    // == init constants ==
    String number = "0";
    byte[] digits;
    int sign;
    boolean flag;
    
    // == encapsulate number 
    
    
    // == constructor ==
    public BigNumber(String num) {
        this.number = num;
       
        sign = 0;
        // == chack the sign of nummber ==
        if (this.number.charAt(0) == '-') {
            this.number = this.number.substring(1);
            
            this.sign = 9;
        }
        else if (this.number.charAt(0) == '+'){
            this.number = this.number.substring(1);
            
            this.sign = 0;
        }
        else {
            this.number = this.number.substring(0);
            
            this.sign = 0;
        }
        
    }
    public String getNumber() {
        return number;
    }
    public int getSign(){
        return sign;
    }
    public byte[] getDigits(){
        return digits;
    }
    
   
    
    public void numberLength(BigNumber other) {
         // == init constants ==
        
        flag = false;
        if (this.number.charAt(0) == '-') {
            this.number = this.number.substring(1);
            
            this.sign = 9;
        }
        else if (this.number.charAt(0) == '+'){
            this.number = this.number.substring(1);
            
            this.sign = 0;
        }
        if (this.number.length() > other.number.length()) {
            other.number = "0".repeat(this.number.length()-other.number.length()) + other.number;
            // == add chars to digits array ==
            this.digits = new byte[this.number.length()];
            other.digits = new byte[other.number.length()];
            for (int i = 0; i<this.digits.length ; i++) {
                this.digits[this.number.length()-1-i] = Byte.parseByte(this.number.charAt(i) + "");
                other.digits[other.number.length()-1-i] = Byte.parseByte(other.number.charAt(i) + "");
            }
            flag = true; // first input number is greater
        }
        else if (this.number.length() == other.number.length()) {
            other.number = "0".repeat(this.number.length()-other.number.length()) + other.number;
            // == add chars to digits array ==
            this.digits = new byte[this.number.length()];
            other.digits = new byte[other.number.length()];
            for (int i = 0; i<this.digits.length ; i++) {
                this.digits[this.number.length()-1-i] = Byte.parseByte(this.number.charAt(i) + "");
                other.digits[other.number.length()-1-i] = Byte.parseByte(other.number.charAt(i) + "");
            }
            flag = true; // first input number is greater
            for (int i = 0; i<this.number.length(); i++) {
                if (this.number.charAt(i) > other.number.charAt(i)) {
                    flag = true;
                    break;
                }
                else if (this.number.charAt(i) == other.number.charAt(i)) {
                    continue;
                }
                else {
                    this.number = "0".repeat(other.number.length()-this.number.length()) + this.number;
                    // == add chars to digits array ==
                    this.digits = new byte[this.number.length()];
                    other.digits = new byte[other.number.length()];
                    for (int j = 0; j<this.digits.length ; j++) {
                        this.digits[this.number.length()-1-j] = Byte.parseByte(this.number.charAt(j) + "");
                        other.digits[other.number.length()-1-j] = Byte.parseByte(other.number.charAt(j) + "");
                    }
                    flag = false;
                    copy = this.digits;
                    this.digits = other.digits;
                    other.digits = copy;
                        }
            }
            
        }
        else {
            this.number = "0".repeat(other.number.length()-this.number.length()) + this.number;
            // == add chars to digits array ==
            this.digits = new byte[this.number.length()];
            other.digits = new byte[other.number.length()];
            for (int i = 0; i<this.digits.length ; i++) {
                this.digits[this.number.length()-1-i] = Byte.parseByte(this.number.charAt(i) + "");
                other.digits[other.number.length()-1-i] = Byte.parseByte(other.number.charAt(i) + "");
            }
            flag = false; // secont input number is greater
            copy = this.digits;
            this.digits = other.digits;
            other.digits = copy;
        }
        
        
        
    }
    
    // == sum method ==
    public String sum(BigNumber other) {
        numberLength(other);
        StringBuilder sum = new StringBuilder();
        // == reset result list and temp ==
        result.removeAll(result);
        temp = 0;
        // == sum of to big number ==
        for (int i = 0; i<this.digits.length; i++) {
            // == it continues until arr2 indexes end ! ==
            if (i < other.digits.length) {
                result.add((this.digits[i]+other.digits[i]+temp)%10);
                temp = (this.digits[i]+other.digits[i]+ temp)/10;
                if (i == this.digits.length-1) {
                    result.add((this.digits[i]+other.digits[i] + temp)/10);
                }
            }
            // == it continues until arr 1 indexes end
            else {
                result.add(this.digits[i] + temp);
                temp = 0;
            }
        }
        
        // == add data on result list to sumResult string ! ==
        if (this.sign + other.sign == 18) {
                System.out.print('-');
            }
            else if (this.sign+other.sign == 0) {
                System.out.print('+');
            }
            
        
        Collections.reverse(result);
        for (int digit : result) {
            sum.append(digit + "");
        }
        
        
        // == return sum ==
        return sum.toString();
    }
    
    
    // minus method ==
    public String subtract(BigNumber other) {
        numberLength(other);
        // == create string builder to return minus ==
        StringBuilder minus = new StringBuilder();
        // == reset result list ==
        result.removeAll(result);
        int borrow = 0;
        // == numbers must have same length ==
        
        // == find minus of to big numbers ==
        for (int i = 0; i < this.digits.length; i++) {
            int diff = (this.digits[i] - borrow - other.digits[i]);
            if (diff < 0) {
                diff += 10;
                if (i == this.digits.length - 1 && diff == -1){
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
                minus.append("+");
            }
        }
        else if (this.sign+other.sign == 0) {
            if (flag) {
            minus.append("+");
            }
            else {
                minus.append("-");
            }
        }
        if (other.sign == 9 && this.sign == 0) {
            minus.append(this.sum(other));
            return minus.toString();
        }
        else if (other.sign == 0 && this.sign == 9) {
            minus.append("-");
            minus.append(this.sum(other));
            return minus.toString();
        }
        
        
        for (int digit : result) {
            minus.append(digit + "");
        }
        return minus.toString();
    }
    
     
    public String mult(BigNumber other) {
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
        if (sign1 + sign2 == 0) {
            multiply.append("+");
        }
        else if (sign1 + sign2 == 18){
            multiply.append("+");
        }
        else {
            multiply.append("-");
        }
        
        for (int digit : result) {
            multiply.append(digit + "");
        }
        
        // == return multiply string as result ==
        return multiply.toString();
    }
    
    public String divide(BigNumber other) {
        numberLength(other);
        // == divide string wil return result ==
        StringBuilder divide = new StringBuilder();
        // == reset result list ==
        result.removeAll(result);
        // == init it again ==
        List<Integer> result2 = new ArrayList<>(Collections.nCopies(this.digits.length, 0));
        int counter = 0;
        
        while (!isNegative(other) || this.subtract(other).equals("0")) {
            
                System.out.println(result2);
                result2.set(0, result2.get(0)+1);
            
                for (int i = 0; i<result2.size(); i++) { // inner for
                    if (result2.get(i) >= 10) {
                        result2.set(i, 0);
                        result2.set(i+1, result2.get(i+1)+1);
                    }
                }// inner for
                this.number = this.subtract(other);
                       
        }
        
        // == add result list to divide string ==
        if (sign1 + sign2 == 0) {
            divide.append("+");
        }
        else if (sign1 + sign2 == 18){
            divide.append("+");
        }
        else {
            divide.append("-");
        }
        
        Collections.reverse(result2);
        for (int digit : result2) {
            divide.append(digit + "");
        }
        return divide.toString();
    }
    
    
    public static char findFirstNonZero(String str) {
        for (char c : str.toCharArray()) {
            if (c != '0') {
                return c;
            }
        }
        return '0'; // Return '0' if no non-zero character is found
    }

    private boolean isNegative(BigNumber other) {
        BigNumber in = new BigNumber(this.number);
        if (in.subtract(other).charAt(0) == '-') {
            return true;
        }
        else {
            return false;
        }
    }
   
    public String divide3(BigNumber other) {
        int BASE = 10000;
        String dividend = this.number;
        String divisor = other.number;

        int[] dividendArr = convertToBase(dividend);
        int[] divisorArr = convertToBase(divisor);

        StringBuilder quotient = new StringBuilder();
        int[] remainder = new int[dividendArr.length];
        int remainderLen = 0;
        for (int i = dividendArr.length - 1; i >= 0; i--) {
            int temp = remainder[0] * BASE + dividendArr[i];
            int count = 0;
            if (temp >= divisorArr[0]) {
                count = temp / divisorArr[0];
                temp -= count * divisorArr[0];
            }
            quotient.insert(0, count);
            remainder[0] = temp;
            remainderLen = 1;
            for (int j = 1; j < divisorArr.length && j <= i; j++) {
                temp = remainder[j] * BASE + dividendArr[i - j];
                if (temp >= divisorArr[j]) {
                    temp -= divisorArr[j];
                } else {
                    remainderLen = j + 1;
                }
                remainder[j] = temp;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = remainderLen - 1; i >= 0; i--) {
            result.append(remainder[i]);
        }
        
        return quotient.toString();
        
    }
    private int[] convertToBase(String num) {
    int len = (num.length() + 3) / 4;
    int[] arr = new int[len];
    int index = 0;
    for (int i = num.length(); i > 0; i -= 4) {
        int endIndex = Math.max(i - 4, 0);
        String sub = num.substring(endIndex, i);
        if (!sub.isEmpty()) {
            arr[index++] = Integer.parseInt(sub);
        }
    }
    return arr;
}
    
    public String divide4(BigNumber other) {
        int counter = 0;
        String[] result = new String[this.number.length()];
        BigNumber temp = new BigNumber(this.number);
        String[] digits = new String[this.number.length()];
        for (int i = 0; i<this.number.length(); i++) {
            digits[i] = this.number.charAt(i)+ "0".repeat(this.number.length()-1-i);
        }
        
        for (int i = 0; i<this.number.length(); i++) {
            BigNumber digit = new BigNumber(digits[i]);
            System.out.println(digit.number + " digits");
            while (true) {
                if (digit.isNegative(other)) {
                    System.out.println("now is negative");
                    break;
                }
                else {
                    counter++;
                    digit.number = digit.subtract(other);
                    System.out.println(digit.number + "   number");
                }             
            }
            System.out.println(counter + "         counter");
            result[i] = counter + "";
            counter = 0;
            
        }
        
        for (int i = 0; i<this.number.length()-1; i++) {
            result[i] = new BigNumber(result[i]).sum(new BigNumber(result[i+1]));
        }
        return result[this.number.length()-1];
    }
    
    public String pow (int n) {
        BigNumber pow = new BigNumber(n + "");
        BigNumber firstNum = new BigNumber(this.number);
        BigNumber secondNum;
        int quotient = n/10;
        int remaining = n%10;
        if (n >= 10) {
            for (int i = 1; i<10; i++) {
                this.number = this.mult(firstNum);
            }
            secondNum = new BigNumber(this.number);
            for (int i = 1; i<quotient; i++) {
                this.number = this.mult(secondNum);
            }
            for (int i = 0; i<remaining; i++) {
                this.number = this.mult(firstNum);
            }
            return this.number;
        }
        else if (n > 0 && n<10){
            for (int i = 1; i<remaining; i++) {
                this.number = this.mult(firstNum);
            }
            return this.number;
        }
        else {
            return 0 + "";
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
        this.number = this.subtract(inc);
        return this.number;
    }
    public String dec() {
        BigNumber dec = new BigNumber("1");
        this.number = this.subtract(dec);
        return this.number;
        
    }

    public static void main(String[] args) {
        String s1 = input.nextLine();
        String s2 = input.nextLine();
        BigNumber num1 = new BigNumber(s1);
        BigNumber num2= new BigNumber(s2);
        
        //System.out.println(num1.sum(num2));
        //System.out.println(num1.subtract(num2));
        //System.out.println(num1.mult(num2));
        //System.out.println(num1.shiftR(50));
        //System.out.println(num1.isNegative(num2));
        //System.out.println(num1.pow(100000));
        System.out.println(num1.divide3(num2));
        
        
            
        
        BigInteger n1 = new BigInteger(s1);
        BigInteger n2 = new BigInteger(s2);
        
        //System.out.println(n1.pow(100000));
        // == sum ==
        //System.out.println(n1.add(n2));
        // == minus ==
        //System.out.println(n1.subtract(n2));
        // == multiply ==
        //System.out.println(n1.multiply(n2));
        // == divide ==
        //System.out.println(n1.divide(n2));
        
        
        
        //sum second way
        //System.out.println(sum(s1,s2));
        // == minus second way
        //System.out.println(bn.subtract(s1));
        //multiply
        //System.out.println(mult(s1,s2));
        //divide second way
        //System.out.println(divide(s1,s2));
        
    }
    
}
