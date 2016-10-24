package leetcode.questions.test.dp;

import leetcode.questions.dp.Dungeon_Game_174;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/10/2016.
 */
public class Dungeon_Game_174_Test {

    @Test
    public void testSimple() {
        int[][] dungeon = new int[][] {
                new int[] {-2,-3,3},
                new int[] {-5,-10,1},
                new int[] {10,30,-5}
        };

        assertEquals(7, Dungeon_Game_174.calculateMinimumHP(dungeon));
    }

}
