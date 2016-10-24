package leetcode.test.questions.data_structures.map;

import leetcode.questions.data_structures.map.Ransom_Note_383;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by albertk on 8/17/16.
 */
public class Ransom_Note_383_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testNullRandomNote() {
        Ransom_Note_383 solution = new Ransom_Note_383();

        solution.canConstruct(null, "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullMagazine() {
        Ransom_Note_383 solution = new Ransom_Note_383();

        solution.canConstruct("", null);
    }

    @Test
    public void testNotFound() {
        Ransom_Note_383 solution = new Ransom_Note_383();

        assertFalse(solution.canConstruct("a", "b"));
    }

    @Test
    public void testNotEnough() {
        Ransom_Note_383 solution = new Ransom_Note_383();

        assertFalse(solution.canConstruct("aa", "ab"));
    }

    @Test
    public void testFoundExact() {
        Ransom_Note_383 solution = new Ransom_Note_383();

        assertTrue(solution.canConstruct("ab", "ab"));
    }

    @Test
    public void testFoundMulti() {
        Ransom_Note_383 solution = new Ransom_Note_383();

        assertTrue(solution.canConstruct("aab", "aab"));
    }

    @Test
    public void testFoundExtra() {
        Ransom_Note_383 solution = new Ransom_Note_383();

        assertTrue(solution.canConstruct("aab", "aababc"));
    }

}
