package leetcode.questions.test.data_structures.binary_indexed_tree;

import leetcode.questions.data_structures.binary_indexed_tree.Count_Smaller_Numbers_After_Self_315;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/20/2016.
 */
public class Count_Smaller_Numbers_After_Self_315_Test {

    @Test
    public void testSimple() {
        List<Integer> result = Count_Smaller_Numbers_After_Self_315.countSmaller(new int[] {5, 2, 6, 1});

        assertEquals(2, result.get(0).intValue());
        assertEquals(1, result.get(1).intValue());
        assertEquals(1, result.get(2).intValue());
        assertEquals(0, result.get(3).intValue());
    }

    @Test
    public void testNegativeAndEqual() {
        List<Integer> result = Count_Smaller_Numbers_After_Self_315.countSmaller(new int[] {-1, -1});

        assertEquals(0, result.get(0).intValue());
        assertEquals(0, result.get(1).intValue());
    }

}
