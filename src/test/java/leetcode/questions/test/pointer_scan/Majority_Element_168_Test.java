package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.Majority_Element_168;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/10/2016.
 */
public class Majority_Element_168_Test {

    @Test
    public void testSimple() {
        assertEquals(1, Majority_Element_168.majorityElement(new int[] { 2, 1, 4, 2, 1, 1, 1, 1}));
    }

}
