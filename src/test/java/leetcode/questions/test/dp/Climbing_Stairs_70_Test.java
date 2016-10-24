package leetcode.questions.test.dp;

import leetcode.questions.dp.Climbing_Stairs_70;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/18/2016.
 */
public class Climbing_Stairs_70_Test {

    @Test
    public void testSimple() {
        assertEquals(1, Climbing_Stairs_70.climbStairs(1));
        assertEquals(2, Climbing_Stairs_70.climbStairs(2));
        assertEquals(3, Climbing_Stairs_70.climbStairs(3));
        assertEquals(5, Climbing_Stairs_70.climbStairs(4));
        assertEquals(8, Climbing_Stairs_70.climbStairs(5));
    }

}
