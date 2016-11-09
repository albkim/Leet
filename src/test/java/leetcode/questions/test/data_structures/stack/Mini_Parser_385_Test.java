package leetcode.questions.test.data_structures.stack;

import leetcode.models.NestedInteger;
import leetcode.questions.data_structures.stack.Mini_Parser_385;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 11/7/2016.
 */
public class Mini_Parser_385_Test {

    @Test
    public void testJustNumber() {
        NestedInteger result = Mini_Parser_385.deserialize("324");

        assertNotNull(result);
        assertTrue(result.isInteger());
        assertEquals(324, result.getInteger().intValue());
    }

    @Test
    public void testList() {
        NestedInteger result = Mini_Parser_385.deserialize("[123,[456,[789]]]");

        assertNotNull(result);
        assertFalse(result.isInteger());
        assertEquals(2, result.getList().size());
        assertEquals(123, result.getList().get(0).getInteger().intValue());
        assertEquals(2, result.getList().get(1).getList().size());
        assertEquals(456, result.getList().get(1).getList().get(0).getInteger().intValue());
        assertEquals(1, result.getList().get(1).getList().get(1).getList().size());
        assertEquals(789, result.getList().get(1).getList().get(1).getList().get(0).getInteger().intValue());
    }

}
