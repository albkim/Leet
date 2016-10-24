package leetcode.questions.dp;

/**
 The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon.
 The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned
 in the top-left room and must fight his way through the dungeon to rescue the princess.

 The knight has an initial health point represented by a positive integer.
 If at any point his health point drops to 0 or below, he dies immediately.

 Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms;
 other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

 In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


 Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

 For example, given the dungeon below, the initial health of the knight must be at least 7
 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

 -2(K)  -3       3
 -5     -10      1
 10     30      -5 (P)


 Notes:
 •The knight's health has no upper bound.
 •Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.

 ---------------------------------------------------------------------------------------------------------

 Seems like a simple backtracking / dp problem. We can dp from the bottom right and keep the minimum of bottom/right path

 Make sure the room where health is lost has at least 1 health

 7       5       2
 6      11      5
 1      1       6

 */
public class Dungeon_Game_174 {

    public static int calculateMinimumHP(int[][] dungeon) {
        if ((dungeon == null) || (dungeon.length == 0) || (dungeon[0].length == 0)) {
            return 0;
        }

        int[][] dp = new int[dungeon.length][dungeon[0].length];

        for (int row = dungeon.length - 1; row >= 0; row--) {
            for (int column = dungeon[0].length - 1; column >= 0; column--) {
                // this is what we required to survive this room
                int healthRequired = dungeon[row][column] < 0
                        ? (dungeon[row][column] * -1)
                        : 0;

                // what we need to move to the next room
                int minPathRequired = Integer.MAX_VALUE;
                if (row + 1 < dungeon.length) {
                    // we can go down
                    minPathRequired = Math.min(minPathRequired, dp[row + 1][column]);
                }
                if (column + 1 < dungeon[0].length) {
                    // we can go down
                    minPathRequired = Math.min(minPathRequired, dp[row][column + 1]);
                }
                if (minPathRequired == Integer.MAX_VALUE) {
                    // if we are not moving we need additional health to stay alive
                    healthRequired += 1;
                }
                else {
                    healthRequired += minPathRequired;
                }

                int healthObtained = dungeon[row][column] < 0
                        ? 0
                        : dungeon[row][column];

                if (healthObtained >= healthRequired) {
                    dp[row][column] = 1;
                }
                else {
                    dp[row][column] = healthRequired - healthObtained;
                }
            }
        }

        return dp[0][0];
    }

}
