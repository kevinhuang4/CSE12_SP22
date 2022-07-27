/**
 * HeapTest.java is a test file for Heap.java.
 */

// import static org.junit.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// import java.util.*;

public class HeapTest {
	@Test
    public void testAddPeekPollIsEmpty() {
        Heap<Integer, Integer> heap = new Heap<>(Integer::compare);
        heap.add(1, 1);
        heap.add(2, 2);
        heap.add(3, 3);
        assertEquals(1, heap.peek());
        assertEquals(1, heap.poll());
        assertEquals(2, heap.peek());
        assertEquals(false, heap.isEmpty());
    }
}
