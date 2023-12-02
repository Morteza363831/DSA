package S4;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Queue;




public class S4q1 {
    public static void main(String[] args) {
      BigInteger bigInteger = new BigInteger("178");
        
        // Test if the bit at index 2 is set
        boolean bit2 = bigInteger.testBit(3);
        System.out.println("Bit at index 2: " + bit2); // This will print "false"
        
        // Test if the bit at index 3 is set
        boolean bit3 = bigInteger.testBit(5);
        System.out.println("Bit at index 3: " + bit3); // This will print "true"
    }
    
}
