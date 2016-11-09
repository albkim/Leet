package leetcode.questions.test;

import leetcode.questions.Perfect_Rectangle_391;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 11/8/2016.
 */
public class Perfect_Rectangle_391_Test {

    @Test
    public void testSimple() {
        assertTrue(Perfect_Rectangle_391.isRectangleCover(new int[][] {
                {1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}
        }));
    }

    @Test
    public void testSimple2() {
        assertTrue(Perfect_Rectangle_391.isRectangleCover(new int[][] {
                {0,0,4,1},{7,0,8,2},{6,2,8,3},{5,1,6,3},{4,0,5,1},{6,0,7,2},{4,2,5,3},{2,1,4,3},{0,1,2,2},{0,2,2,3},{4,1,5,2},{5,0,6,1}
        }));
    }

}
