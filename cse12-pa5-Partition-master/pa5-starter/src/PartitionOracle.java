
// These are some imports that the course staff found useful, feel free to use them
// along with other imports from java.util.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.HashMap;

public class PartitionOracle {

    /**
     * Feel free to use this method to call partition. It catches any exceptions or
     * errors and returns a definitely-invalid pivot (-1) to turn errors into
     * potential failures. For example, in testPartition, you may use
     * 
     * runPartition(p, someArray, someLow, someHigh)
     * 
     * instead of
     * 
     * p.partition(someArray, someLow, someHigh)
     * 
     * @param p
     * @param strs
     * @param low
     * @param high
     * @return
     */
    public static int runPartition(Partitioner p, String[] strs, int low, int high) {
        try {
            return p.partition(strs, low, high);
        } catch (Throwable t) {
            return -1;
        }
    }

    // The three methods below are for you to fill in according to the PA writeup.
    // Feel free to make other helper methods as needed.
    /*
    * Return null if the pivot and after array reflect a correct partitioning of 
    * the before array between low and high.
    *
    * Return a non-null String (your choice) describing why it isn't a valid
    * partition if it is not a valid result. You might choose Strings like these,
    * though there may be more you want to report:
    *
    * - "after array doesn't have same elements as before"
    * - "Item before pivot too large"
    * - "Item after pivot too small"
    */
    public static String isValidPartitionResult(String[] before, int low, int high, int pivot, String[] after) {
        /* create a hashmap that contains the Strings in the before array (keys)
        and the number of times they occur (values)
        */
        HashMap<String, Integer> map = new HashMap<>();
        for(String str: before) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        /* reduce the count for a String in the hashmap by 1
        if it occurs in the after array
        */
        for (String str: after) {
            if (!map.containsKey(str)) {
                return "after array doesn't have same elements as before";
            } else {
                map.put(str, map.get(str) - 1);
            }
        }
        /* if all the values in the hashmap are 0
        the before and after array have the same elements
        */
        for (Integer i: map.values()) {
            if (i != 0) {
                return "after array doesn't have same elements as before";
            }
        }

        /* Check if the values before low and high changed */
        for (int i = 0; i < low; i++) {
            if (!before[i].equals(after[i])) {
                return "values before low (exclusive) changed";
            }
        }
        for (int i = high; i < before.length; i++) {
            if (!before[i].equals(after[i])) {
                return "values after high (inclusive) changed";
            }
        }
    
        /* verify if the pivot is valid */
        if (pivot >= after.length || pivot < 0) {
            return "invalid pivot";
        }

        /* At all indices from low up to the pivot index the string is smaller than or equal to the value at the pivot index */
        for (int i = low; i <= pivot; i++) {
            if (after[i].compareTo(after[pivot]) > 0) {
                return "Item before pivot too large";
            }
        }
        /* At all indices from the pivot index up to high - 1, the string is larger than or equal to the value at the pivot index */
        for (int i = pivot; i < high; i++) {
            if (after[i].compareTo(after[pivot]) < 0) {
                return "Item after pivot too small";
            }
        }

        return null;
    }

    public static String[] generateInput(int n) {
        String[] generated = new String[n];
        Random r;
        int asciiForACapLetter;
        for (int i = 0; i < generated.length; i++) {
            r = new Random();
            asciiForACapLetter = r.nextInt(26) + 65;  // Generates a random letter from A - Z
            generated[i] = Character.toString((char)(asciiForACapLetter));
        }
        return generated;
    }

    public static CounterExample findCounterExample(Partitioner p) {
        String[] generated;
        int low;
        int high;
        String[] partitioned;
        int pivot;
        String result;
        for (int i = 0; i < 10; i++) {
            generated = generateInput(1 + new Random().nextInt(100));
            low = new Random().nextInt(generated.length);
            high = new Random().nextInt(generated.length - low) + low;
            if (high - low <= 1) {
                continue;
            }
            partitioned = Arrays.copyOf(generated, generated.length);
            pivot = p.partition(partitioned, low, high);
            result = isValidPartitionResult(generated, low, high, pivot, partitioned);
            if (result == null) {
                continue;
            }
            return new CounterExample(generated, low, high, pivot, partitioned, result);
        }
        return null;
    }

}
