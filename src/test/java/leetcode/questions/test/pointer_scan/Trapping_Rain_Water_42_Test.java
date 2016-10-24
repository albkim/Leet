package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.Trapping_Rain_Water_42;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/11/2016.
 */
public class Trapping_Rain_Water_42_Test {

    @Test
    public void testSimple() {
        assertEquals(6, Trapping_Rain_Water_42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

 }
