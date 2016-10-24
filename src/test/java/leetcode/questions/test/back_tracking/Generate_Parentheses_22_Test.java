package leetcode.questions.test.back_tracking;

import leetcode.questions.back_tracking.Generate_Parentheses_22;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/5/2016.
 */
public class Generate_Parentheses_22_Test {

    @Test
    public void testSimple() {
        List<String> result = Generate_Parentheses_22.generateParenthesis(3);

        assertEquals(5, result.size());
        assertEquals("((()))", result.get(0));
        assertEquals("(()())", result.get(1));
        assertEquals("(())()", result.get(2));
        assertEquals("()(())", result.get(3));
        assertEquals("()()()", result.get(4));
    }
}
