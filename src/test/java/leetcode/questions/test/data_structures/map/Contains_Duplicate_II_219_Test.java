package leetcode.questions.test.data_structures.map;

import leetcode.questions.data_structures.map.Contains_Duplicate_II_219;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * Created by Sang on 10/13/2016.
 */
public class Contains_Duplicate_II_219_Test {

    @Test
    public void testSimple() {
        assertFalse(Contains_Duplicate_II_219.ContainsNearbyDuplicate(new int[] {1, 2, 1}, 0));
    }

}
