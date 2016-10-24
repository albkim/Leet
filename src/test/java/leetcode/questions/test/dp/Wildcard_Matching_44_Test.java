package leetcode.questions.test.dp;

import leetcode.questions.dp.Wildcard_Matching_44;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Sang on 9/12/2016.
 */
public class Wildcard_Matching_44_Test {

    @Test
    public void testSample() {
        assertFalse(Wildcard_Matching_44.isMatch("aa", "a"));
        assertTrue(Wildcard_Matching_44.isMatch("aa", "aa"));
        assertFalse(Wildcard_Matching_44.isMatch("aaa", "aa"));
        assertTrue(Wildcard_Matching_44.isMatch("aa", "*"));
        assertTrue(Wildcard_Matching_44.isMatch("aa", "a*"));
        assertTrue(Wildcard_Matching_44.isMatch("ab", "?*"));
        assertFalse(Wildcard_Matching_44.isMatch("aab", "c*a*b"));
    }

    @Test
    public void testComplex() {
        assertFalse(Wildcard_Matching_44.isMatch("b", "?*?"));
        assertTrue(Wildcard_Matching_44.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
    }

}
