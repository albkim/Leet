package leetcode.questions.test.back_tracking;

import leetcode.questions.back_tracking.Permutations_46;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/13/2016.
 */
public class Permutations_46_Test {

    @Test
    public void testSimple() {
        assertEquals(6, Permutations_46.permute(new int[]{1, 2, 3}).size());
    }

}
