package leetcode.questions.test.dp;

import leetcode.questions.dp.Perfect_Squares_279;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/16/2016.
 */
public class Perfect_Squares_279_Test {

    @Test
    public void testSimple() {
        assertEquals(3, Perfect_Squares_279.numSquares(12));
        assertEquals(2, Perfect_Squares_279.numSquares(13));
    }

}
