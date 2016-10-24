package leetcode.questions.test.number;

import leetcode.questions.number.Plus_One_66;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/18/2016.
 */
public class Plus_One_66_Test {

    @Test
    public void testSimple() {
        assertEquals(5, Plus_One_66.plusOne(new int[] {4})[0]);
    }

    @Test
    public void testCarry() {
        assertEquals(2, Plus_One_66.plusOne(new int[] {1,9})[0]);
    }

    @Test
    public void testCarry2() {
        assertEquals(1, Plus_One_66.plusOne(new int[] {9})[0]);
    }

}
