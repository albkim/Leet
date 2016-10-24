package leetcode.questions.test.data_structures.stack;

import leetcode.questions.data_structures.stack.Min_Stack_155;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/9/2016.
 */
public class Min_Stack_155_Test {

    @Test
    public void testSimple() {
        Min_Stack_155 minStack = new Min_Stack_155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertEquals(-3, minStack.getMin());
        minStack.pop();
        assertEquals(0, minStack.top());
        assertEquals(-2, minStack.getMin());
    }

}
