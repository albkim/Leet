package leetcode.hard.test;

import leetcode.hard.Longest_SubString_Without_Repeating_3;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 8/23/2016.
 */
public class Longest_SubString_Without_Repeating_3_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testBadInput() {
        Longest_SubString_Without_Repeating_3.lengthOfLongestSubstring(null);
    }

    @Test
    public void testExamples() {
        assertEquals(2, Longest_SubString_Without_Repeating_3.lengthOfLongestSubstring("abba"));
        assertEquals(3, Longest_SubString_Without_Repeating_3.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, Longest_SubString_Without_Repeating_3.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, Longest_SubString_Without_Repeating_3.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    public void testLastPiece() {
        assertEquals(9, Longest_SubString_Without_Repeating_3.lengthOfLongestSubstring("pwabcwdefgh"));
    }

    @Test
    public void testLinearSkip() {
        assertEquals(9, Longest_SubString_Without_Repeating_3.lengthOfLongestSubstring("pwabcwdefghww"));
    }

}
