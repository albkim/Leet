package leetcode.questions.test;

import leetcode.questions.Longest_Common_Prefix_14;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/5/2016.
 */
public class Longest_Common_Prefix_14_Test {

    @Test
    public void testInvalidInput() {
        assertEquals("", Longest_Common_Prefix_14.longestCommonPrefix(new String[] {}));
    }

    @Test
    public void testSimple() {
        assertEquals("a", Longest_Common_Prefix_14.longestCommonPrefix(new String[] {"aa", "a"}));
        assertEquals("a", Longest_Common_Prefix_14.longestCommonPrefix(new String[] {"a"}));
    }

}
