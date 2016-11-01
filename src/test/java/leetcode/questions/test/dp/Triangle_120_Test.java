package leetcode.questions.test.dp;

import leetcode.questions.dp.Triangle_120;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/3/2016.
 */
public class Triangle_120_Test {

    @Test
    public void testSimple() {
        List<List<Integer>> triangle = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3,4),
                Arrays.asList(6,5,7),
                Arrays.asList(4,1,8,3)
        );

        assertEquals(11, Triangle_120.minimumTotal(triangle));
    }

    @Test
    public void testComplex() {
        List<List<Integer>> triangle = Arrays.asList(
                Arrays.asList(-1),
                Arrays.asList(3,2),
                Arrays.asList(-3,1,-1)
        );

        assertEquals(-1, Triangle_120.minimumTotal(triangle));
    }

}
