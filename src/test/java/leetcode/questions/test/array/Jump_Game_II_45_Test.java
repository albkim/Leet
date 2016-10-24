package leetcode.questions.test.array;

import leetcode.questions.array.Jump_Game_II_45;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/12/2016.
 */
public class Jump_Game_II_45_Test {

    @Test
    public void testEdge() {
        assertEquals(1, Jump_Game_II_45.jump(new int[] {2,3,1}));
    }

    @Test
    public void testSimple() {
        assertEquals(2, Jump_Game_II_45.jump(new int[] {2,3,1,1,4}));
        assertEquals(2, Jump_Game_II_45.jump(new int[] {1,2,0,1}));
        assertEquals(2, Jump_Game_II_45.jump(new int[] {2,3,0,1,4}));
    }

    @Test
    public void testComplex() {
        assertEquals(3, Jump_Game_II_45.jump(new int[] {5,9,3,2,1,0,2,3,3,1,0,0}));
    }

}
