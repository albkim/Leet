package leetcode.questions.test.dp;

import leetcode.questions.dp.Coin_Change_322;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/21/2016.
 */
public class Coin_Change_322_Test {

    @Test
    public void testSimple() {
        assertEquals(3, Coin_Change_322.coinChange(new int[] {1, 2, 5}, 11));
    }

    @Test
    public void testSimple1() {
        assertEquals(4, Coin_Change_322.coinChange(new int[] {2, 5, 10, 1}, 27));
    }

    @Test
    public void testEdge() {
        assertEquals(-1, Coin_Change_322.coinChange(new int[] {2}, 3));
    }

}
