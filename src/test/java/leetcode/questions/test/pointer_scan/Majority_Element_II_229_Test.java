package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.Majority_Element_II_229;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/14/2016.
 */
public class Majority_Element_II_229_Test {

    @Test
    public void testMajority() {
        List<Integer> result = Majority_Element_II_229.majorityElementGeneric(new int[]{2, 1, 4, 2, 1, 1, 1, 1}, 1);

        assertEquals(1, result.size());
        assertEquals(1, result.get(0).intValue());
    }

    @Test
    public void testMajorityTwo() {
        List<Integer> result = Majority_Element_II_229.majorityElementGeneric(new int[]{2, 2, 4, 2, 1, 1, 1, 4}, 2);

        assertEquals(2, result.size());
        assertEquals(2, result.get(0).intValue());
        assertEquals(1, result.get(1).intValue());
    }

    @Test
    public void testMajorityTwoEdge() {
        List<Integer> result = Majority_Element_II_229.majorityElementGeneric(new int[]{6, 6, 6, 7, 7}, 2);

        assertEquals(2, result.size());
        assertEquals(6, result.get(0).intValue());
        assertEquals(7, result.get(1).intValue());
    }

    @Test
    public void testMajorityTwoEdge1() {
        List<Integer> result = Majority_Element_II_229.majorityElementGeneric(new int[]{8,8,7,7,7}, 2);

        assertEquals(2, result.size());
        assertEquals(8, result.get(0).intValue());
        assertEquals(7, result.get(1).intValue());
    }

    @Test
    public void testMajorityTwoEdge2() {
        List<Integer> result = Majority_Element_II_229.majorityElementGeneric(new int[]{1,1,1,2,3,4,5,6}, 2);

        assertEquals(1, result.size());
        assertEquals(1, result.get(0).intValue());
    }

}
