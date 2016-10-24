package leetcode.questions.test;

import leetcode.questions.H_Index_274;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/16/2016.
 */
public class H_Index_274_Test {

    @Test
    public void testSimple() {
        assertEquals(3, H_Index_274.hIndex(new int[] {3, 0, 6, 1, 5}));
    }

}
