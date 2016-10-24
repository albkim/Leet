package leetcode.questions.test.bits;

import leetcode.questions.bits.Number_Of_1_Bits_191;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/11/2016.
 */
public class Number_Of_1_Bits_191_Test {

    @Test
    public void testSimple() {
        assertEquals(3, Number_Of_1_Bits_191.hammingWeight(11));
    }

}
