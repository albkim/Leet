package leetcode.questions.test.array;

import leetcode.questions.array.Gas_Station_134;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/6/2016.
 */
public class Gas_Station_134_Test {

    @Test
    public void testSimple() {
        assertEquals(-1, Gas_Station_134.canCompleteCircuit(new int[] {4}, new int[] {5}));
    }

    @Test
    public void testSimple1() {
        assertEquals(1, Gas_Station_134.canCompleteCircuit(new int[] {1,2}, new int[] {2,1}));
    }

    @Test
    public void testSimple2() {
        assertEquals(-1, Gas_Station_134.canCompleteCircuit(new int[] {2,4}, new int[] {3,4}));
    }

}
