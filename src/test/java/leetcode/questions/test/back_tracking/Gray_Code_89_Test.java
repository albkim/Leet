package leetcode.questions.test.back_tracking;

import leetcode.questions.back_tracking.Gray_Code_89;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/25/2016.
 */
public class Gray_Code_89_Test {

    @Test
    public void testSimple() {
        List<Integer> result = Gray_Code_89.grayCode(2);
        assertEquals(4, result.size());

        assertEquals(0, result.get(0).intValue());
        assertEquals(1, result.get(1).intValue());
        assertEquals(3, result.get(2).intValue());
        assertEquals(2, result.get(3).intValue());
    }

    @Test
    public void testComplex() {
        List<Integer> result = Gray_Code_89.grayCode(3);
        assertEquals(8, result.size());

        assertEquals(0, result.get(0).intValue());
        assertEquals(1, result.get(1).intValue());
        assertEquals(3, result.get(2).intValue());
        assertEquals(2, result.get(3).intValue());
        assertEquals(6, result.get(4).intValue());
        assertEquals(7, result.get(5).intValue());
        assertEquals(5, result.get(6).intValue());
        assertEquals(4, result.get(7).intValue());
    }

}
