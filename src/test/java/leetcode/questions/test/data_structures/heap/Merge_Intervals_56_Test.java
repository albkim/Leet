package leetcode.questions.test.data_structures.heap;

import leetcode.questions.data_structures.heap.Merge_Intervals_56;
import leetcode.models.Interval;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/17/2016.
 */
public class Merge_Intervals_56_Test {

    @Test
    public void testSimple() {
        List<Interval> result = Merge_Intervals_56.merge(Arrays.asList(
                new Interval(1,3),
                new Interval(2,6),
                new Interval(8,10),
                new Interval(15,18)
        ));

        assertEquals(3, result.size());

        assertEquals(1, result.get(0).start);
        assertEquals(6, result.get(0).end);

        assertEquals(8, result.get(1).start);
        assertEquals(10, result.get(1).end);

        assertEquals(15, result.get(2).start);
        assertEquals(18, result.get(2).end);
    }

    @Test
    public void testComplex() {
        List<Interval> result = Merge_Intervals_56.merge(Arrays.asList(
                new Interval(1,4),
                new Interval(0,4)
        ));

        assertEquals(1, result.size());

        assertEquals(0, result.get(0).start);
        assertEquals(4, result.get(0).end);
    }

}
