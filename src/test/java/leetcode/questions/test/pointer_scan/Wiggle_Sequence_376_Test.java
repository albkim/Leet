package leetcode.test.questions.pointer_scan;

import leetcode.questions.pointer_scan.Wiggle_Sequence_376;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by albertk on 8/25/16.
 */
public class Wiggle_Sequence_376_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testNull() {
        Wiggle_Sequence_376.wiggleMaxLength(null);
    }

    @Test
    public void testValid() {
        assertEquals(6, Wiggle_Sequence_376.wiggleMaxLength(new int[] {1,7,4,9,2,5}));
        assertEquals(7, Wiggle_Sequence_376.wiggleMaxLength(new int[] {1,17,5,10,13,15,10,5,16,8}));
        assertEquals(2, Wiggle_Sequence_376.wiggleMaxLength(new int[] {1,2,3,4,5,6,7,8,9}));
        assertEquals(5, Wiggle_Sequence_376.wiggleMaxLength(new int[] {1, 10, 11, 10, 11, 10}));
    }
}
