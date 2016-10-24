package leetcode.test.questions.pointer_scan;

import leetcode.questions.pointer_scan.Find_K_Pairs_With_Smallest_Sum_373;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by albertk on 8/30/16.
 */
public class Find_K_Pairs_With_Smallest_Sum_373_Test {

    @Test
    public void testValidSimple() {
        List<int[]> result = Find_K_Pairs_With_Smallest_Sum_373.kSmallestPairs(new int[] {1,7,11}, new int[] {2,4,6}, 3);

        assertEquals(3, result.size());
        assertEquals(1, result.get(0)[0]);
        assertEquals(2, result.get(0)[1]);
        assertEquals(1, result.get(1)[0]);
        assertEquals(4, result.get(1)[1]);
        assertEquals(1, result.get(2)[0]);
        assertEquals(6, result.get(2)[1]);
    }

    @Test
    public void testValidCross() {
        List<int[]> result = Find_K_Pairs_With_Smallest_Sum_373.kSmallestPairs(new int[] {1,1,2}, new int[] {1,2,3}, 2);

        assertEquals(2, result.size());
        assertEquals(1, result.get(0)[0]);
        assertEquals(1, result.get(0)[1]);
        assertEquals(1, result.get(1)[0]);
        assertEquals(1, result.get(1)[1]);
    }

    @Test
    public void testValidOnlyOneItem() {
        List<int[]> result = Find_K_Pairs_With_Smallest_Sum_373.kSmallestPairs(new int[] {1,2}, new int[] {3}, 2);

        assertEquals(2, result.size());
        assertEquals(1, result.get(0)[0]);
        assertEquals(3, result.get(0)[1]);
        assertEquals(2, result.get(1)[0]);
        assertEquals(3, result.get(1)[1]);
    }

    @Test
    public void testValidOnlyOneItemFirst() {
        List<int[]> result = Find_K_Pairs_With_Smallest_Sum_373.kSmallestPairs(new int[] {3}, new int[] {1,2}, 2);

        assertEquals(2, result.size());
        assertEquals(3, result.get(0)[0]);
        assertEquals(1, result.get(0)[1]);
        assertEquals(3, result.get(1)[0]);
        assertEquals(2, result.get(1)[1]);
    }

    @Test
    public void testValidKMoreThanPossible() {
        List<int[]> result = Find_K_Pairs_With_Smallest_Sum_373.kSmallestPairs(new int[] {3}, new int[] {1,2}, 3);

        assertEquals(2, result.size());
        assertEquals(3, result.get(0)[0]);
        assertEquals(1, result.get(0)[1]);
        assertEquals(3, result.get(1)[0]);
        assertEquals(2, result.get(1)[1]);
    }

    @Test
    public void testValidMultiplePointers() {
        List<int[]> result = Find_K_Pairs_With_Smallest_Sum_373.kSmallestPairs(
                new int[] {-10,-4,0,0,6},
                new int[] {3,5,6,7,8,100},
                10);

        assertEquals(10, result.size());
        assertEquals(-10, result.get(0)[0]);
        assertEquals(3, result.get(0)[1]);
        assertEquals(-10, result.get(1)[0]);
        assertEquals(5, result.get(1)[1]);
        assertEquals(-10, result.get(2)[0]);
        assertEquals(6, result.get(2)[1]);
        assertEquals(-10, result.get(3)[0]);
        assertEquals(7, result.get(3)[1]);
        assertEquals(-10, result.get(4)[0]);
        assertEquals(8, result.get(4)[1]);
        assertEquals(-4, result.get(5)[0]);
        assertEquals(3, result.get(5)[1]);
        assertEquals(-4, result.get(6)[0]);
        assertEquals(5, result.get(6)[1]);
        assertEquals(-4, result.get(7)[0]);
        assertEquals(6, result.get(7)[1]);
        assertEquals(0, result.get(8)[0]);
        assertEquals(3, result.get(8)[1]);
        assertEquals(-4, result.get(9)[0]);
        assertEquals(7, result.get(9)[1]);
    }

}
