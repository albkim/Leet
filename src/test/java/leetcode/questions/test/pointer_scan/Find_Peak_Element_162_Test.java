package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.Find_Peak_Element_162;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/9/2016.
 */
public class Find_Peak_Element_162_Test {

    @Test
    public void testSimple() {
        assertEquals(2, Find_Peak_Element_162.findPeakElement(new int[] {1, 2, 3, 1}));
    }

}
