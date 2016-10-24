package leetcode.questions.test.array;

import leetcode.questions.array.Jump_Game_55;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/15/2016.
 */
public class Jump_Game_55_Test {

    @Test
    public void testEdge() {
        assertTrue(Jump_Game_55.canJump(new int[] {0}));
    }

    @Test
    public void testTrue() {
        assertTrue(Jump_Game_55.canJump(new int[] {2,3,1,1,4}));
    }

    @Test
    public void testFalse() {
        assertFalse(Jump_Game_55.canJump(new int[]{3, 2, 1, 0, 4}));
    }

}
