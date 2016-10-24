package leetcode.questions.test.back_tracking;

import leetcode.questions.dp.Nim_Game_292;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * Created by Sang on 10/17/2016.
 */
public class Nim_Game_292_Test {

    @Test
    public void testSimple() {
        assertFalse(Nim_Game_292.canWinNim(4));
    }

}
