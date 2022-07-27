public class CorrectPartitioner implements Partitioner{
    public int partition(String[] strs, int low, int high) {
        if ((strs == null) || (strs.length == 0)) {
            return -1;
        }
        if ((high - low) <= 1) {
            return low;
        }
        int pivotStartIndex = high - 1;
	    String pivot = strs[pivotStartIndex];
	    int smallerBefore = low, largerAfter = high - 2;
	  
	    while (smallerBefore <= largerAfter) {
		    if (strs[smallerBefore].compareTo(pivot) < 0) {
			    smallerBefore += 1;
		    }
		    else {
			    swap(strs, smallerBefore, largerAfter);
			    largerAfter -= 1;
		    }
	    }
	  
	    swap(strs, smallerBefore, pivotStartIndex);
	    return smallerBefore;
    }

    // helper method: swap the element at i1 and the element at i2 in array
    public static void swap(String[] array, int i1, int i2) {
        String temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }
}