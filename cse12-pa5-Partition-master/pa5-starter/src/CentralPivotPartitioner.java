// You can (and should) add "implements Partitioner" below once you have the implementation ready
public class CentralPivotPartitioner implements Partitioner{
    public int partition(String[] strs, int low, int high) {
        // if ((high - low) <= 1) {
        //     return high;
        // }
	    int lowIndex = low, highIndex = high - 1;
        int pivotIndex = (high + low) / 2;
        String pivot = strs[pivotIndex];
        int returnIndex = pivotIndex;
        while (lowIndex <= highIndex) {
            while (strs[lowIndex].compareTo(pivot) < 0) {
                lowIndex += 1;
            }
            while (strs[highIndex].compareTo(pivot) > 0) {
                highIndex -= 1;
            }
		    if (lowIndex <= highIndex) {
                if (lowIndex == returnIndex) {
                    returnIndex = highIndex;
                } else if (highIndex == returnIndex) {
                    returnIndex = lowIndex;
                }
			    swap(strs, lowIndex, highIndex);
                if (lowIndex == returnIndex) {
                    highIndex -= 1;
                } else if (highIndex == returnIndex) {
                    lowIndex += 1;
                } else {
                    lowIndex += 1;
                    highIndex -= 1;
                }
		    }
	    }
        return returnIndex;
    }

    // helper method: swap the element at i1 and the element at i2 in array
    public static void swap(String[] array, int i1, int i2) {
        String temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }
}
