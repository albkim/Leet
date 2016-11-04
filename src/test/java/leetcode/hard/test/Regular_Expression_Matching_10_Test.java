package leetcode.hard.test;

import leetcode.hard.Regular_Expression_Matching_10;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/2/2016.
 */
public class Regular_Expression_Matching_10_Test {

    @Test
    public void testSample() {
        assertFalse(Regular_Expression_Matching_10.isMatch("aa", "a"));
        assertTrue(Regular_Expression_Matching_10.isMatch("aa", "aa"));
        assertFalse(Regular_Expression_Matching_10.isMatch("aaa", "aa"));
        assertTrue(Regular_Expression_Matching_10.isMatch("aa", "a*"));
        assertTrue(Regular_Expression_Matching_10.isMatch("aa", ".*"));
        assertTrue(Regular_Expression_Matching_10.isMatch("ab", ".*"));
        assertTrue(Regular_Expression_Matching_10.isMatch("aab", "c*a*b"));
    }

    @Test
    public void testComplexity() {
        assertFalse(Regular_Expression_Matching_10.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
        assertTrue(Regular_Expression_Matching_10.isMatch("aaa", "ab*ac*a"));
    }

    @Test
    public void testEdge() {
        assertFalse(Regular_Expression_Matching_10.isMatch("a", "aaaaa"));
    }

}
