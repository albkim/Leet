package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.Container_With_Most_Water_11;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/2/2016.
 */
public class Container_With_Most_Water_11_Test {

    @Test
    public void testValid() {
        assertEquals(20, Container_With_Most_Water_11.maxArea(new int[]{10, 1, 10, 1}));
    }

}
