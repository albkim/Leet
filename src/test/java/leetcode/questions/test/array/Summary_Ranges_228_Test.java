package leetcode.questions.test.array;

import leetcode.questions.array.Summary_Ranges_228;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/14/2016.
 */
public class Summary_Ranges_228_Test {

    @Test
    public void testSimple() {
        List<String> result = Summary_Ranges_228.summaryRanges(new int[] {0,1,2,4,5,7});

        assertEquals(3, result.size());

        assertEquals("0->2", result.get(0));
        assertEquals("4->5", result.get(1));
        assertEquals("7", result.get(2));
    }

}
