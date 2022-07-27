public class MyTest {
    public static void main(String[] args) {
        String[] strs = {"P", "Z", "Q", "E", "G", "J", "L", "K", "E", "U"};
        int low = 2;
        int high = 7;
        int pivotStartIndex = (high - 1 + low) / 2;
        System.out.println("pivotStartIndex: " + pivotStartIndex);
        String pivot = strs[pivotStartIndex];
        System.out.println("pivot: " + pivot);
        int smallerBefore = low, largerAfter = high - 1;
        System.out.println("smallerBefore: " + smallerBefore);
        System.out.println("largerAfter: " + largerAfter);
        int returnIndex = pivotStartIndex;
        System.out.println("returnIndex: " + returnIndex);
        System.out.println("start");
        while (smallerBefore < largerAfter) {
            while (strs[smallerBefore].compareTo(pivot) < 0) {
                smallerBefore += 1;
            }
            System.out.println("smallerBefore: " + smallerBefore);
            while (strs[largerAfter].compareTo(pivot) > 0) {
                largerAfter -= 1;
            }
            System.out.println("largerAfter: " + largerAfter);
            if (smallerBefore <= largerAfter) {
                if (smallerBefore == returnIndex) {
                    returnIndex = largerAfter;
                    System.out.println("returnIndex: " + returnIndex);
                } else if (largerAfter == returnIndex) {
                    returnIndex = smallerBefore;
                    System.out.println("returnIndex: " + returnIndex);
                }
			    swap(strs, smallerBefore, largerAfter);
                smallerBefore += 1;
                largerAfter -= 1;
                System.out.println("returnIndex: " + returnIndex);
		    }
        }
    }
    public static void swap(String[] array, int i1, int i2) {
        String temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }
}
