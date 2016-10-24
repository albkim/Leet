package leetcode.questions.test;

import leetcode.questions.Patching_Array_330;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/22/2016.
 */
public class Patching_Array_330_Test {

    @Test
    public void testSimple() {
        assertEquals(1, Patching_Array_330.minPatches(new int[] {1, 3}, 6));
        assertEquals(2, Patching_Array_330.minPatches(new int[] {1, 5, 10}, 20));
        assertEquals(0, Patching_Array_330.minPatches(new int[] {1, 2, 2}, 5));
        assertEquals(3, Patching_Array_330.minPatches(new int[] {}, 7));
    }

    @Test
    public void testSimple1() {
        assertEquals(2, Patching_Array_330.minPatches(new int[]{1,7,21,31,34,37,40,43,49,87,90,92,93,98,99}, 12));
    }

    @Test
    public void testSimple2() {
        assertEquals(2, Patching_Array_330.minPatches(new int[]{1,2,16,19,31,35,36,64,64,67,69,71,73,74,76,79,80,91,95,96,97}, 8));
    }

}
