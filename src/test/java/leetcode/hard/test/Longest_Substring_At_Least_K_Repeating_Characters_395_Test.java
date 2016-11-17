package leetcode.hard.test;

import leetcode.hard.Longest_Substring_At_Least_K_Repeating_Characters_395;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 11/10/2016.
 */
public class Longest_Substring_At_Least_K_Repeating_Characters_395_Test {

    @Test
    public void testSimple() {
        assertEquals(3, Longest_Substring_At_Least_K_Repeating_Characters_395.longestSubstring("aaabb", 3));
    }

    @Test
    public void testSimple1() {
        assertEquals(5, Longest_Substring_At_Least_K_Repeating_Characters_395.longestSubstring("ababbc", 2));
    }

    @Test
    public void testSimple2() {
        assertEquals(6, Longest_Substring_At_Least_K_Repeating_Characters_395.longestSubstring("aaabbb", 3));
    }

    @Test
    public void testSimple3() {
        assertEquals(0, Longest_Substring_At_Least_K_Repeating_Characters_395.longestSubstring("ababacb", 3));
    }

    @Test
    public void testSimple4() {
        assertEquals(6, Longest_Substring_At_Least_K_Repeating_Characters_395.longestSubstring("abbbbbbcaa", 3));
    }

}
