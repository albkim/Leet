package leetcode.questions.test.sorting;

import leetcode.questions.sorting.Wiggle_Sort_II_324;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Sang on 10/21/2016.
 */
public class Wiggle_Sort_II_324_Test {

    @Test
    public void testSimple() {
        int[] input = new int[] {6,13,5,4,5,2};
        Wiggle_Sort_II_324.wiggleSort(input);
        assertArrayEquals(new int[] {5, 6, 4, 13, 2, 5}, input);
    }

    @Test
    public void testEdge() {
        int[] input = new int[] {2,1};
        Wiggle_Sort_II_324.wiggleSort(input);
        assertArrayEquals(new int[] {1,2}, input);
    }

    @Test
    public void testSimple1() {
        int[] input = new int[] {1,3,2,2,3,1};
        Wiggle_Sort_II_324.wiggleSort(input);
        assertArrayEquals(new int[] {2,3,1,3,1,2}, input);
    }

    @Test
    public void testSimple2() {
        int[] input = new int[] {1,5,1,1,6,4};
        Wiggle_Sort_II_324.wiggleSort(input);
        assertArrayEquals(new int[] {1,5,1,6,1,4}, input);
    }

    @Test
    public void testSimple3() {
        int[] input = new int[] {1,3,2,2,2,1,1,3,1,1,2};
        Wiggle_Sort_II_324.wiggleSort(input);
        assertArrayEquals(new int[] {2,3,1,3,1,2,1,2,1,2,1}, input);
    }

}
