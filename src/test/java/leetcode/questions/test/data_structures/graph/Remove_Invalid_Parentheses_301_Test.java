package leetcode.questions.test.data_structures.graph;

import leetcode.questions.data_structures.graph.Remove_Invalid_Parentheses_301;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/18/2016.
 */
public class Remove_Invalid_Parentheses_301_Test {

    @Test
    public void testSimple() {
        List<String> result = Remove_Invalid_Parentheses_301.removeInvalidParentheses(")()(");

        assertEquals(1, result.size());

        assertEquals("()", result.get(0));
    }

    @Test
    public void testSimple1() {
        List<String> result = Remove_Invalid_Parentheses_301.removeInvalidParentheses("()())()");

        assertEquals(2, result.size());

        assertEquals("(())()", result.get(0));
        assertEquals("()()()", result.get(1));
    }

    @Test
    public void testEdge() {
        List<String> result = Remove_Invalid_Parentheses_301.removeInvalidParentheses(")(");

        assertEquals(1, result.size());
        assertEquals("", result.get(0));
    }

    @Test
    public void testSimpleLetter() {
        List<String> result = Remove_Invalid_Parentheses_301.removeInvalidParentheses("(a)())()");

        assertEquals(2, result.size());

        assertEquals("(a())()", result.get(0));
        assertEquals("(a)()()", result.get(1));
    }

}
