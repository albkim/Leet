package leetcode.questions.test.data_structures.map;

import leetcode.questions.data_structures.map.Bulls_Cows_299;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/17/2016.
 */
public class Bulls_Cows_299_Test {

    @Test
    public void testSimple() {
        assertEquals("1A3B", Bulls_Cows_299.getHint("1807", "7810"));
        assertEquals("1A1B", Bulls_Cows_299.getHint("1123", "0111"));
    }

}
