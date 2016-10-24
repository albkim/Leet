package leetcode.questions.test.data_structures.stack;

import leetcode.questions.data_structures.stack.Evaluate_Reverse_Polish_Notation_150;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/8/2016.
 */
public class Evaluate_Reverse_Polish_Notation_150_Test {

    @Test
    public void testSimple() {
        assertEquals(6, Evaluate_Reverse_Polish_Notation_150.evalRPN(new String[] { "4", "13", "5", "/", "+" }));
        assertEquals(9, Evaluate_Reverse_Polish_Notation_150.evalRPN(new String[] { "2", "1", "+", "3", "*" }));
    }

}
