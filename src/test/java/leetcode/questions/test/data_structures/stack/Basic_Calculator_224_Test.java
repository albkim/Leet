package leetcode.questions.test.data_structures.stack;

import leetcode.questions.data_structures.stack.Basic_Calculator_224;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/14/2016.
 */
public class Basic_Calculator_224_Test {

    @Test
    public void testSimple() {
        assertEquals(2, Basic_Calculator_224.calculate("1 + 1"));
        assertEquals(3, Basic_Calculator_224.calculate(" 2-1 + 2 "));
    }

    @Test
    public void testParen() {
        assertEquals(23, Basic_Calculator_224.calculate("(1+(4+5+2)-3)+(6+8)"));
    }

}
