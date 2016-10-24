package leetcode.questions.test.array;

import leetcode.questions.array.Product_Array_Except_Self_238;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Sang on 10/15/2016.
 */
public class Product_Array_Except_Self_238_Test {

    @Test
    public void testSimple() {
        assertArrayEquals(new int[] {24,12,8,6}, Product_Array_Except_Self_238.productExceptSelf(new int[] {1,2,3,4}));
    }

}
