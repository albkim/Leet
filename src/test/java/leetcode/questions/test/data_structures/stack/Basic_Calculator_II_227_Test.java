package leetcode.questions.test.data_structures.stack;

import leetcode.questions.data_structures.stack.Basic_Calculator_II_227;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/14/2016.
 */
public class Basic_Calculator_II_227_Test {

    @Test
    public void testSimple() {
        assertEquals(7, Basic_Calculator_II_227.calculate("3+2*2"));
        assertEquals(1, Basic_Calculator_II_227.calculate(" 3/2 "));
        assertEquals(5, Basic_Calculator_II_227.calculate(" 3+5 / 2 "));
    }

}
