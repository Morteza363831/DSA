package S4;

import java.util.ArrayList;
import java.util.List;

public class S4q3 {
    public static void main(String[] args) {
        array arr1 = new array(5);
        arr1.insert(1);
        arr1.insert(2);
        arr1.insert(3);
        arr1.insert(4);
        arr1.insert(5);
        arr1.insert(6);
        for (int i = 0; i<arr1.arr.length; i++) {
            System.out.println(arr1.arr[i]);
        }
        
    }
    
    
}

class array {
    int[] arr;
    int i;
    public array(int n) {
        arr = new int[n];
        i =0;
    }
    
    public void insert(int val) {
        if (i == arr.length) {
            int[] copy = new int[arr.length];
            for (int j = 0; j<arr.length; j++) {
                copy[j] = arr[j];
            }
            arr = new int[arr.length+1];
            for (int j = 0; j<arr.length-1; j++) {
                arr[j] = copy[j];
            }
        }
        arr[i] = val;
        i++;
    }
    
    public int remove(int index) {
        return arr[index] = 0;
    }
    
    
}
