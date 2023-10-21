package S1;



import java.util.ArrayList;
import java.util.List;

public class S1q16 {
    
    public static void printSubsets(int[] set) {
    printSubsets(set, 0, new ArrayList<Integer>());
    }

    public static void printSubsets(int[] set, int index, List<Integer> subset) {
        if (index == set.length) {
            System.out.println(subset);
            return;
        }
        printSubsets(set, index + 1, subset);
        List<Integer> newSubset = new ArrayList<Integer>(subset);
        newSubset.add(set[index]);
        printSubsets(set, index + 1, newSubset);
    }
    
    public static void main(String[] args) {
        int[] set = {1, 2, 3};
        printSubsets(set);
    }
}
