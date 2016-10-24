package leetcode.questions.test.back_tracking;

import leetcode.questions.back_tracking.Subsets_78;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/20/2016.
 */
public class Subsets_78_Test {

    @Test
    public void testSimple() {
        List<List<Integer>> result = Subsets_78.subsets(new int[]{1, 2, 3});

        assertEquals(8, result.size());

        assertEquals(1, result.get(0).get(0).intValue());

        assertEquals(2, result.get(1).get(0).intValue());

        assertEquals(3, result.get(2).get(0).intValue());

        assertEquals(1, result.get(3).get(0).intValue());
        assertEquals(2, result.get(3).get(1).intValue());

        assertEquals(1, result.get(4).get(0).intValue());
        assertEquals(3, result.get(4).get(1).intValue());

        assertEquals(2, result.get(5).get(0).intValue());
        assertEquals(3, result.get(5).get(1).intValue());

        assertEquals(1, result.get(6).get(0).intValue());
        assertEquals(2, result.get(6).get(1).intValue());
        assertEquals(3, result.get(6).get(2).intValue());

        assertEquals(0, result.get(7).size());
    }

}
