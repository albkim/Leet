package leetcode.questions.test.back_tracking;

import leetcode.questions.back_tracking.Permutations_II_47;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/13/2016.
 */
public class Permutations_II_47_Test {

    @Test
    public void testSimple() {
        assertEquals(6, Permutations_II_47.permuteUnique(new int[] {1, 2, 3}).size());
        assertEquals(3, Permutations_II_47.permuteUnique(new int[] {1, 1, 2}).size());
        assertEquals(6, Permutations_II_47.permuteUnique(new int[] {1, 1, 2, 2}).size());
    }

}
