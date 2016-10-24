package leetcode.questions.test.array;

import leetcode.questions.array.Remove_Element_27;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/5/2016.
 */
public class Remove_Element_27_Test {

    @Test
    public void testSimple() {
        int[] input = new int[] {3,2,2,3};

        assertEquals(2, Remove_Element_27.removeElement(input, 3));
        assertEquals(2, input[0]);
        assertEquals(2, input[1]);
    }
}
