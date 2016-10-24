package leetcode.questions.test;

import leetcode.questions.Rectangle_Area_223;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/14/2016.
 */
public class Rectangle_Area_223_Test {

    @Test
    public void testSimple() {
        assertEquals(16, Rectangle_Area_223.computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
    }

    @Test
    public void testSimple1() {
        // 16 + 12 - 4
        assertEquals(24, Rectangle_Area_223.computeArea(-2, -2, 2, 2, -3, -3, 3, -1));
    }

}
