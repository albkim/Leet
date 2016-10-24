package leetcode.questions.test.recursion;

import leetcode.questions.recursion.Unique_Binary_Search_Trees_II_95;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/30/2016.
 */
public class Unique_Binary_Search_Trees_II_95_Test {

    @Test
    public void testSimple() {
        assertEquals(1, Unique_Binary_Search_Trees_II_95.generateTrees(1).size());
        assertEquals(2, Unique_Binary_Search_Trees_II_95.generateTrees(2).size());
        assertEquals(5, Unique_Binary_Search_Trees_II_95.generateTrees(3).size());
    }

}
