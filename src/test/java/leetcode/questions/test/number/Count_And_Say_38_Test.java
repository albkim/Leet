package leetcode.questions.test.number;

import leetcode.questions.number.Count_And_Say_38;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/10/2016.
 */
public class Count_And_Say_38_Test {

    @Test
    public void testOne() {
        assertEquals("1", Count_And_Say_38.countAndSay(1));
    }

    @Test
    public void testTwo() {
        assertEquals("11", Count_And_Say_38.countAndSay(2));
    }

    @Test
    public void testThree() {
        assertEquals("21", Count_And_Say_38.countAndSay(3));
    }

    @Test
    public void testFour() {
        assertEquals("1211", Count_And_Say_38.countAndSay(4));
    }

    @Test
    public void testFive() {
        assertEquals("111221", Count_And_Say_38.countAndSay(5));
    }

}
