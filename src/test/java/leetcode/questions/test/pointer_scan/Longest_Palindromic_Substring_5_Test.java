package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.Longest_Palindromic_Substring_5;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 8/31/2016.
 */
public class Longest_Palindromic_Substring_5_Test {

    @Test
    public void testOneChar() {
        assertEquals("a", Longest_Palindromic_Substring_5.longestPalindrome("a"));
    }

    @Test
    public void testTwoChar() {
        assertEquals("aa", Longest_Palindromic_Substring_5.longestPalindrome("aa"));
    }

    @Test
    public void testPattern1() {
        assertEquals("aba", Longest_Palindromic_Substring_5.longestPalindrome("aba"));
    }

    @Test
    public void testPattern2() {
        assertEquals("abba", Longest_Palindromic_Substring_5.longestPalindrome("abba"));
    }

}
