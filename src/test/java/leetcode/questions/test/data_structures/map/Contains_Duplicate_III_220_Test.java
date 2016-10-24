package leetcode.questions.test.data_structures.map;

import leetcode.questions.data_structures.map.Contains_Duplicate_III_220;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/13/2016.
 */
public class Contains_Duplicate_III_220_Test {

    @Test
    public void testSimple() {
        assertFalse(Contains_Duplicate_III_220.containsNearbyAlmostDuplicate(new int[]{4,2}, 2, 1));
    }

    @Test
    public void testSimple1() {
        assertFalse(Contains_Duplicate_III_220.containsNearbyAlmostDuplicate(new int[]{-1,-1}, 1, -1));
    }

    @Test
    public void testSimple2() {
        assertFalse(Contains_Duplicate_III_220.containsNearbyAlmostDuplicate(new int[]{2,4}, 1, 1));
    }

    @Test
    public void testSimple3() {
        assertTrue(Contains_Duplicate_III_220.containsNearbyAlmostDuplicate(new int[]{3, 6, 0, 4}, 2, 2));
    }

    @Test
    public void testSimple4() {
        assertTrue(Contains_Duplicate_III_220.containsNearbyAlmostDuplicate(new int[]{4,1,-1,6,5}, 3, 1));
    }

}
