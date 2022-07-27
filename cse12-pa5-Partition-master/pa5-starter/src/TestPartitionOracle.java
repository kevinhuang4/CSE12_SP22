import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This is an example of how to implement the Partitioner interface to implement
 * a concrete Partitioner. You can use this bad implementation to test your PartitionOracle,
 * to ensure that it works in detecting a bad Partitioner. You should add a correct implementation
 * of a Partitioner here, maybe one from class, to verify that your PartitionOracle also works
 * correctly on good implementations. Once you implement part 2, you can also test those Partitioner
 * implementations here as well.
 * 
 */
class CopyFirstElementPartition implements Partitioner {
    public int partition(String[] strs, int low, int high) {
        if (high - low < 1)
            return 0;
        for (int i = 0; i < strs.length; i += 1) {
            strs[i] = strs[0];
        }
        return 0;
    }
}

public class TestPartitionOracle {
    @Test
    public void testCopyFirstElementPartition() {
        CounterExample ce = PartitionOracle.findCounterExample(new CopyFirstElementPartition());
        System.out.println(ce);
        assertNotNull(ce);
    }

    @Test
    public void testIsValidPartitionResult() {
        String[] before0 = {"h", "s", "o", "a", "k", "q", "w"};
        String[] after0 = {"h", "a", "k", "o", "s", "q", "w"};
        String result0 = PartitionOracle.isValidPartitionResult(before0, 1, 6, 2, after0);
        assertNull(result0);
        String[] before1 = {"h", "s", "o", "a", "k", "q", "w"};
        String[] after1 = {"a", "h", "k", "o", "q", "s", "w"};
        String result1 = PartitionOracle.isValidPartitionResult(before1, 0, 7, 5, after1);
        assertNull(result1);
        String[] before2 = {"a", "a", "a", "a", "a", "a", "a"};
        String[] after2 = {"a", "a", "a", "a", "a", "a", "a"};
        String result2 = PartitionOracle.isValidPartitionResult(before2, 0, 7, 4, after2);
        assertNull(result2);
        String[] before3 = {"h", "s", "o", "a", "k", "q", "w"};
        String[] after3= {"a", "h", "k", "o", "u", "s", "w"};
        String result3 = PartitionOracle.isValidPartitionResult(before3, 0, 7, 6, after3);
        assertNotNull(result3);
        String[] before4 = {"h", "s", "o", "a", "k", "q", "w"};
        String[] after4= {"b", "a", "k", "o", "s", "q", "w"};
        String result4 = PartitionOracle.isValidPartitionResult(before4, 1, 6, 2, after4);
        assertNotNull(result4);
        String[] before5 = {"h", "s", "o", "a", "k", "q", "w"};
        String[] after5 = {"h", "a", "k", "o", "s", "q", "x"};
        String result5 = PartitionOracle.isValidPartitionResult(before5, 1, 6, 2, after5);
        assertNotNull(result5);
        String[] before6 = {"h", "s", "o", "a", "k", "q", "w"};
        String[] after6 = {"a", "h", "q", "o", "k", "s", "w"};
        String result6 = PartitionOracle.isValidPartitionResult(before6, 0, 7, 3, after6);
        assertNotNull(result6);
    }

    @Test
    public void testGenerateInput() {
        String[] generated0 = PartitionOracle.generateInput(5);
        assertEquals(5, generated0.length);
        String[] generated1 = PartitionOracle.generateInput(21);
        assertEquals(21, generated1.length);
    }

    @Test
    public void testFindCounterExample() {
        Partitioner correctP = new CorrectPartitioner();
        Partitioner incorrectP = new IncorrectPartitioner();
        Partitioner centralP = new CentralPivotPartitioner();
        Partitioner firstP = new FirstElePivotPartitioner();
        Partitioner webP = new WebPartitioner();
        assertNull(PartitionOracle.findCounterExample(correctP));
        assertNotNull(PartitionOracle.findCounterExample(incorrectP));
        assertNull(PartitionOracle.findCounterExample(centralP));
        assertNull(PartitionOracle.findCounterExample(firstP));
        // assertNull(PartitionOracle.findCounterExample(webP));
    }
}
