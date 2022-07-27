// You can (and should) add "implements Partitioner" below once you have the implementation ready
public class WebPartitioner implements Partitioner{
    /* url: "https://www.geeksforgeeks.org/implement-various-types-of-partitions-in-quick-sort-in-java/"
     * reusing code: "https://www.geeksforgeeks.org/copyright-information/"
     * Changes: 
     *     0. static to non-static
     *     1. int to String, > < = to compareTo
     *     2. reduce the last index of the subarray that needs to be partitioned by 1 because we're excluding the index high
     *     3. loop from start to high - 1 instead of start to high, similar to the change above
     * It's buggy according to my tests. There could be elements that have the same value as the pivot inside the subarray, and the method doesn't take that into account.
     * Worstcase: θ(n)
     */
    public int partition(String a[], int start, int high)
    {
        // Creating temporary
        String temp[] = new String[high - start];
 
        // Choosing a pivot
        String pivot = a[high - 1];
        int index = 0;
       
        // smaller number
        for (int i = start; i < high; ++i) {
            if (a[i].compareTo(pivot) < 0)
            {
                temp[index++] = a[i];
            }
        }
       
        // pivot position
        int position = index;
       
        // Placing the pivot to its original position
        temp[index++] = pivot;
       
        for (int i = start; i < high; ++i)
        {
            if (a[i].compareTo(pivot) > 0)
            {
                temp[index++] = a[i];
            }
        }
 
        // Change the original array
        for (int i = start; i < high; ++i) {
            a[i] = temp[i - start];
        }
       
        // return the position of the pivot
        return position;
    }
}
