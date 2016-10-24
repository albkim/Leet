package leetcode.questions.test.back_tracking;

import leetcode.questions.back_tracking.Combinations_77;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/20/2016.
 */
public class Combinations_77_Test {

    @Test
    public void testSimple(){
        List<List<Integer>> result = Combinations_77.combine(4, 2);

        assertEquals(6, result.size());

        assertEquals(1, result.get(0).get(0).intValue());
        assertEquals(2, result.get(0).get(1).intValue());

        assertEquals(1, result.get(1).get(0).intValue());
        assertEquals(3, result.get(1).get(1).intValue());

        assertEquals(1, result.get(2).get(0).intValue());
        assertEquals(4, result.get(2).get(1).intValue());

        assertEquals(2, result.get(3).get(0).intValue());
        assertEquals(3, result.get(3).get(1).intValue());

        assertEquals(2, result.get(4).get(0).intValue());
        assertEquals(4, result.get(4).get(1).intValue());

        assertEquals(3, result.get(5).get(0).intValue());
        assertEquals(4, result.get(5).get(1).intValue());
    }

}
