package leetcode.test.questions.array;

import leetcode.questions.array.Intersection_Two_Arrays_349;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by albertk on 10/4/16.
 */
public class Intersection_Two_Arrays_349_Test {

    @Test
    public void testSimple() {
        int[] result = Intersection_Two_Arrays_349.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});

        assertEquals(1, result.length);
        assertArrayEquals(new int[] {2}, result);
    }

}
