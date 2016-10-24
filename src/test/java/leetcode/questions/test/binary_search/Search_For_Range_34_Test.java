package leetcode.questions.test.binary_search;

import leetcode.questions.binary_search.Search_For_Range_34;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/10/2016.
 */
public class Search_For_Range_34_Test {

    @Test
    public void testNotFound() {
        int[] result = Search_For_Range_34.searchRange(new int[] {6, 6, 7, 8, 8}, 5);
        assertEquals(-1, result[0]);
        assertEquals(-1, result[1]);
    }

    @Test
    public void testEdge() {
        int[] result = Search_For_Range_34.searchRange(new int[] {6, 6, 7, 8, 8}, 7);
        assertEquals(2, result[0]);
        assertEquals(2, result[1]);
    }

    @Test
    public void testSimple() {
        int[] result = Search_For_Range_34.searchRange(new int[] {6, 6, 7, 8, 8}, 8);
        assertEquals(3, result[0]);
        assertEquals(4, result[1]);
    }

    @Test
    public void testComplex() {
        int[] result = Search_For_Range_34.searchRange(new int[] {6, 6, 7, 8, 8, 8, 8, 9, 10}, 8);
        assertEquals(3, result[0]);
        assertEquals(6, result[1]);
    }

}
