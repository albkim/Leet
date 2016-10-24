package leetcode.test.questions.bits;

import leetcode.questions.bits.Sum_Two_Integer_371;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by albertk on 8/31/16.
 */
public class Sum_Two_Integer_371_Test {

    @Test
    public void testValid() {
        assertEquals(3, Sum_Two_Integer_371.getSum(1, 2));
        assertEquals(5, Sum_Two_Integer_371.getSum(2, 3));
        assertEquals(5, Sum_Two_Integer_371.getSum(2, 3));
    }

}
