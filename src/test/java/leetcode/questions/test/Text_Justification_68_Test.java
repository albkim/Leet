package leetcode.questions.test;

import leetcode.questions.Text_Justification_68;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/18/2016.
 */
public class Text_Justification_68_Test {

    @Test
    public void testSimple() {
        List<String> result = Text_Justification_68.fullJustify(new String[] {
                "This", "is", "an", "example", "of", "text", "justification."
        }, 16);

        assertEquals(3, result.size());

        assertEquals("This    is    an", result.get(0));
        assertEquals("example  of text", result.get(1));
        assertEquals("justification.  ", result.get(2));
    }

    @Test
    public void testLastLine() {
        List<String> result = Text_Justification_68.fullJustify(new String[] {
                "What","must","be","shall","be."
        }, 12);

        assertEquals(2, result.size());

        assertEquals("What must be", result.get(0));
        assertEquals("shall be.   ", result.get(1));
    }

}
