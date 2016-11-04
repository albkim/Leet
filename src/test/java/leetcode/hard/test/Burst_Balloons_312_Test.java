package leetcode.questions.test.dp;

import leetcode.questions.dp.Burst_Balloons_312;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/19/2016.
 */
public class Burst_Balloons_312_Test {

    @Test
    public void testSimple() {
        assertEquals(167, Burst_Balloons_312.maxCoins(new int[] {3, 1, 5, 8}));
    }

    @Test
    public void testSimple1() {
        assertEquals(832, Burst_Balloons_312.maxCoins(new int[] {2,3,7,9,1,8,2}));
    }

    @Test
    public void testSlow() {
        assertEquals(1654, Burst_Balloons_312.maxCoins(new int[] {7,9,8,0,7,1,3,5,5,2,3}));
    }

    @Test
    public void testComplex() {
        assertEquals(1583373, Burst_Balloons_312.maxCoins(new int[] {35,16,83,87,84,59,48,41}));
    }

}
