package leetcode.questions.test.sorting;

import leetcode.questions.sorting.Sort_Colors_75;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/19/2016.
 */
public class Sort_Colors_75_Test {

    @Test
    public void testEdge() {
        int[] input = new int[]{0};

        Sort_Colors_75.sortColors(input);

        assertEquals(0, input[0]);
    }

    @Test
    public void testEdge1() {
        int[] input = new int[]{1, 0};

        Sort_Colors_75.sortColors(input);

        assertEquals(0, input[0]);
        assertEquals(1, input[1]);
    }

    @Test
    public void testEdge2() {
        int[] input = new int[]{0, 2, 1};

        Sort_Colors_75.sortColors(input);

        assertEquals(0, input[0]);
        assertEquals(1, input[1]);
        assertEquals(2, input[2]);
    }

    @Test
    public void testSimple() {
        int[] input = new int[] { 1, 2, 0, 1, 2, 0, 1, 2 };

        Sort_Colors_75.sortColors(input);

        assertEquals(0, input[0]);
        assertEquals(0, input[1]);
        assertEquals(1, input[2]);
        assertEquals(1, input[3]);
        assertEquals(1, input[4]);
        assertEquals(2, input[5]);
        assertEquals(2, input[6]);
        assertEquals(2, input[7]);
    }

}
