package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.Minimum_Window_Substring_76;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/20/2016.
 */
public class Minimum_Window_Substring_76_Test {

    @Test
    public void testSimple() {
        assertEquals("BANC", Minimum_Window_Substring_76.minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    public void testCasing() {
        assertEquals("a", Minimum_Window_Substring_76.minWindow("a", "a"));
    }

    @Test
    public void testNotFound() {
        assertEquals("", Minimum_Window_Substring_76.minWindow("ADOBECODEBANC", "ABCZ"));
    }

    @Test
    public void testDupe() {
        assertEquals("BAANC", Minimum_Window_Substring_76.minWindow("ADOBECODEBAANC", "AABC"));
    }


}
