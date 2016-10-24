package leetcode.test.questions.data_structures.tree_map;

import leetcode.models.Interval;
import leetcode.questions.data_structures.treemap.Data_Stream_Disjoint_Intervals_352;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by albertk on 10/3/16.
 */
public class Data_Stream_Disjoint_Intervals_352_Test {

    @Test
    public void testSimple() {
        Data_Stream_Disjoint_Intervals_352 interval = new Data_Stream_Disjoint_Intervals_352();

        interval.addNum(1);
        List<Interval> result = interval.getIntervals();

        assertEquals(1, result.size());
        assertEquals(1, result.get(0).start);
        assertEquals(1, result.get(0).end);

        interval.addNum(1);
        result = interval.getIntervals();
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).start);
        assertEquals(1, result.get(0).end);

        interval.addNum(3);
        result = interval.getIntervals();

        assertEquals(2, result.size());
        assertEquals(1, result.get(0).start);
        assertEquals(1, result.get(0).end);
        assertEquals(3, result.get(1).start);
        assertEquals(3, result.get(1).end);

        interval.addNum(7);
        result = interval.getIntervals();

        assertEquals(3, result.size());
        assertEquals(1, result.get(0).start);
        assertEquals(1, result.get(0).end);
        assertEquals(3, result.get(1).start);
        assertEquals(3, result.get(1).end);
        assertEquals(7, result.get(2).start);
        assertEquals(7, result.get(2).end);

        interval.addNum(2);
        result = interval.getIntervals();

        assertEquals(2, result.size());
        assertEquals(1, result.get(0).start);
        assertEquals(3, result.get(0).end);
        assertEquals(7, result.get(1).start);
        assertEquals(7, result.get(1).end);

        interval.addNum(6);
        result = interval.getIntervals();

        assertEquals(2, result.size());
        assertEquals(1, result.get(0).start);
        assertEquals(3, result.get(0).end);
        assertEquals(6, result.get(1).start);
        assertEquals(7, result.get(1).end);
    }

}
