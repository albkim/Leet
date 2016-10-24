package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.Three_Sum_15;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/5/2016.
 */
public class Three_Sum_15_Test {

    @Test
    public void testSample() {
        List<List<Integer>> result = Three_Sum_15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});

        assertEquals(2, result.size());

        assertEquals(-1, result.get(0).get(0).intValue());
        assertEquals(-1, result.get(0).get(1).intValue());
        assertEquals(2, result.get(0).get(2).intValue());

        assertEquals(-1, result.get(1).get(0).intValue());
        assertEquals(0, result.get(1).get(1).intValue());
        assertEquals(1, result.get(1).get(2).intValue());
    }

}
