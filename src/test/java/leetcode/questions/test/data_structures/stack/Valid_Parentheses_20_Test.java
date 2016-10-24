package leetcode.questions.test.data_structures.stack;

import leetcode.questions.data_structures.stack.Valid_Parentheses_20;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/5/2016.
 */
public class Valid_Parentheses_20_Test {

    @Test
    public void testSimple() {
        assertTrue(Valid_Parentheses_20.isValid("()"));
        assertTrue(Valid_Parentheses_20.isValid("()[]{}"));

        assertFalse(Valid_Parentheses_20.isValid("(]"));
        assertFalse(Valid_Parentheses_20.isValid("([)]"));
    }

}
