package leetcode.questions.test.back_tracking;

import leetcode.questions.back_tracking.Permutation_Sequence_60;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/17/2016.
 */
public class Permutation_Sequence_60_Test {

    @Test
    public void testKTooLarge() {
        assertEquals("", Permutation_Sequence_60.getPermutation(3, 9));
    }

    @Test
    public void testSimple() {
        assertEquals("123", Permutation_Sequence_60.getPermutation(3, 1));
        assertEquals("132", Permutation_Sequence_60.getPermutation(3, 2));
        assertEquals("231", Permutation_Sequence_60.getPermutation(3, 4));
        assertEquals("321", Permutation_Sequence_60.getPermutation(3, 6));
    }

}
