package leetcode.hard.test;

import leetcode.hard.Range_Sum_Query_Mutable_307;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/19/2016.
 */
public class Range_Sum_Query_Mutable_307_Test {

    @Test
    public void testSimple() {
        Range_Sum_Query_Mutable_307 solution = new Range_Sum_Query_Mutable_307(new int[] {1,3,5});

        assertEquals(9, solution.sumRange(0, 2));
        solution.update(1, 2);
        assertEquals(8, solution.sumRange(0, 2));
    }

    @Test
    public void testSimple1() {
        Range_Sum_Query_Mutable_307 solution = new Range_Sum_Query_Mutable_307(new int[] {-1});

        assertEquals(-1, solution.sumRange(0, 0));
        solution.update(0, 1);
        assertEquals(1, solution.sumRange(0, 0));
    }

    @Test
    public void testSimple2() {
        Range_Sum_Query_Mutable_307 solution = new Range_Sum_Query_Mutable_307(new int[] {0,9,5,7,3});

        assertEquals(3, solution.sumRange(4, 4));
        assertEquals(15, solution.sumRange(2, 4));
        solution.update(0, 1);
        assertEquals(1, solution.sumRange(0, 0));
    }

    @Test
    public void testSimple3() {
        Range_Sum_Query_Mutable_307 solution = new Range_Sum_Query_Mutable_307(new int[] {7,2,7,2,0});

        solution.update(4,6);
        solution.update(0,2);
        solution.update(0,9);
        // 9, 2, 7, 2, 6
        assertEquals(6, solution.sumRange(4, 4));
        solution.update(3,8);
        // 9, 2, 7, 8, 6
        assertEquals(32, solution.sumRange(0, 4));
        solution.update(4, 1);
        assertEquals(26, solution.sumRange(0, 3));
        assertEquals(27, solution.sumRange(0,4));
    }

}
