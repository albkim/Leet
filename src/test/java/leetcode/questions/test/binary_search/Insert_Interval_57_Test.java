package leetcode.questions.test.binary_search;

import leetcode.questions.binary_search.Insert_Interval_57;
import leetcode.models.Interval;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/17/2016.
 */
public class Insert_Interval_57_Test {

    @Test
    public void testSimpleMerge() {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1,3));
        input.add(new Interval(6,9));

        List<Interval> result = Insert_Interval_57.insert(input, new Interval(2,5));

        assertEquals(2, result.size());

        assertEquals(1, result.get(0).start);
        assertEquals(5, result.get(0).end);

        assertEquals(6, result.get(1).start);
        assertEquals(9, result.get(1).end);
    }

    @Test
    public void testMultiMerge() {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1,2));
        input.add(new Interval(3,5));
        input.add(new Interval(6,7));
        input.add(new Interval(8,10));
        input.add(new Interval(12,16));

        List<Interval> result = Insert_Interval_57.insert(input, new Interval(4,9));

        assertEquals(3, result.size());

        assertEquals(1, result.get(0).start);
        assertEquals(2, result.get(0).end);

        assertEquals(3, result.get(1).start);
        assertEquals(10, result.get(1).end);

        assertEquals(12, result.get(2).start);
        assertEquals(16, result.get(2).end);
    }

    @Test
    public void testNew() {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(6, 9));

        List<Interval> result = Insert_Interval_57.insert(input, new Interval(10,11));

        assertEquals(3, result.size());

        assertEquals(1, result.get(0).start);
        assertEquals(3, result.get(0).end);

        assertEquals(6, result.get(1).start);
        assertEquals(9, result.get(1).end);

        assertEquals(10, result.get(2).start);
        assertEquals(11, result.get(2).end);
    }

    @Test
    public void testMiddle() {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(6, 9));

        List<Interval> result = Insert_Interval_57.insert(input, new Interval(4,5));

        assertEquals(3, result.size());

        assertEquals(1, result.get(0).start);
        assertEquals(3, result.get(0).end);

        assertEquals(4, result.get(1).start);
        assertEquals(5, result.get(1).end);

        assertEquals(6, result.get(2).start);
        assertEquals(9, result.get(2).end);
    }

}
