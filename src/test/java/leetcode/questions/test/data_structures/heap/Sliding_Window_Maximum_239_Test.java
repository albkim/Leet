package leetcode.questions.test.data_structures.heap;

import leetcode.questions.data_structures.heap.Sliding_Window_Maximum_239;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Sang on 10/15/2016.
 */
public class Sliding_Window_Maximum_239_Test {

    @Test
    public void testSimple() {
        assertArrayEquals(new int[] {3,3,5,5,6,7}, Sliding_Window_Maximum_239.maxSlidingWindow(new int[]
                {1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }

}
