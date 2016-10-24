package leetcode.questions.test.recursion;

import leetcode.questions.recursion.Pascals_Triangle_118;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/2/2016.
 */
public class Pascals_Triangle_118_Test {

    @Test
    public void testSimple() {
        List<List<Integer>> result = Pascals_Triangle_118.generate(5);

        assertEquals(5, result.size());

        assertEquals(1, result.get(0).get(0).intValue());

        assertEquals(1, result.get(1).get(0).intValue());
        assertEquals(1, result.get(1).get(1).intValue());

        assertEquals(1, result.get(2).get(0).intValue());
        assertEquals(2, result.get(2).get(1).intValue());
        assertEquals(1, result.get(2).get(2).intValue());

        assertEquals(1, result.get(3).get(0).intValue());
        assertEquals(3, result.get(3).get(1).intValue());
        assertEquals(3, result.get(3).get(2).intValue());
        assertEquals(1, result.get(3).get(3).intValue());

        assertEquals(1, result.get(4).get(0).intValue());
        assertEquals(4, result.get(4).get(1).intValue());
        assertEquals(6, result.get(4).get(2).intValue());
        assertEquals(4, result.get(4).get(3).intValue());
        assertEquals(1, result.get(4).get(4).intValue());
    }

}
