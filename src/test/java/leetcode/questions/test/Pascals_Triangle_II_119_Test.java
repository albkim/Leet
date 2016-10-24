package leetcode.questions.test;

import leetcode.questions.Pascals_Triangle_II_119;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/2/2016.
 */
public class Pascals_Triangle_II_119_Test {

    @Test
    public void testSimple() {
        List<Integer> result = Pascals_Triangle_II_119.getRow(1);

        assertEquals(1, result.get(0).intValue());
        assertEquals(1, result.get(1).intValue());

        result = Pascals_Triangle_II_119.getRow(2);

        assertEquals(1, result.get(0).intValue());
        assertEquals(2, result.get(1).intValue());
        assertEquals(1, result.get(2).intValue());

        result = Pascals_Triangle_II_119.getRow(3);

        assertEquals(1, result.get(0).intValue());
        assertEquals(3, result.get(1).intValue());
        assertEquals(3, result.get(2).intValue());
        assertEquals(1, result.get(3).intValue());

        result = Pascals_Triangle_II_119.getRow(4);

        assertEquals(1, result.get(0).intValue());
        assertEquals(4, result.get(1).intValue());
        assertEquals(6, result.get(2).intValue());
        assertEquals(4, result.get(3).intValue());
        assertEquals(1, result.get(4).intValue());
    }

}
