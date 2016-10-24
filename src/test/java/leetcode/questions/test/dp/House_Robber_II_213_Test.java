package leetcode.questions.test.dp;

import leetcode.questions.dp.House_Robber_II_213;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/13/2016.
 */
public class House_Robber_II_213_Test {

    @Test
    public void testEdge() {
        assertEquals(1, House_Robber_II_213.rob(new int[] {1}));
    }

    @Test
    public void testSimple() {
        assertEquals(1, House_Robber_II_213.rob(new int[] {1,1,1}));
    }

    @Test
    public void testSimple1() {
        assertEquals(2, House_Robber_II_213.rob(new int[] {1,1,1,1}));
    }

}
