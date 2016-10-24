package leetcode.questions.test.data_structures.stack;

import leetcode.questions.data_structures.stack.Longest_Valid_Parentheses_32;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/9/2016.
 */
public class Longest_Valid_Parentheses_32_Test {

    @Test
    public void testValid() {
        assertEquals(0, Longest_Valid_Parentheses_32.longestValidParentheses(""));
    }

    @Test
    public void testCombination() {
        assertEquals(4, Longest_Valid_Parentheses_32.longestValidParentheses("()()"));
        assertEquals(6, Longest_Valid_Parentheses_32.longestValidParentheses("(()())"));
    }

    @Test
    public void testExtraOpen() {
        assertEquals(2, Longest_Valid_Parentheses_32.longestValidParentheses("(((()"));
    }

    @Test
    public void testExtraClose() {
        assertEquals(2, Longest_Valid_Parentheses_32.longestValidParentheses("())))"));
    }

    @Test
    public void testMax() {
        assertEquals(4, Longest_Valid_Parentheses_32.longestValidParentheses("())))()()"));
    }

}
