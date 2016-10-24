package leetcode.questions.dp;

/**
 You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time
 one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner.
 You will take the first turn to remove the stones.

 Both of you are very clever and have optimal strategies for the game. Write a function to determine
 whether you can win the game given the number of stones in the heap.

 For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones
 you remove, the last stone will always be removed by your friend.

 ---------------------------------------------------------------------------------------------------

 Simple backtracking


 */
public class Nim_Game_292 {

    public static boolean canWinNim(int n) {
        if (n <= 3) {
            return true;
        }

        return canWinNimDP(n);
    }

    private static boolean canWinNimTrick(int n) {
        return n%4!=0; //lose at 4,8,12....
    }

    private static boolean canWinNimDP(int n) {
        boolean[] dp = new boolean[4];

        // base
        for (int number = 1; number <= Math.min(n, 3); number++) {
            dp[number - 1] = true;
        }

        for (int number = 4; number <= n; number++) {
            for (int other = 1; other <= 3; other++) {
                int oldIndex = (number - other - 1) % 4;
                if (!dp[oldIndex]) {
                    int newIndex = (number - 1) % 4;
                    dp[newIndex] = true;
                    break;
                }
            }
        }

        int newIndex = (n - 1) % 4;
        return dp[newIndex];
    }

    private static boolean canWinNimRecursive(int n, boolean myTurn) {
        if (n <= 3) {
            return myTurn;
        }

        for (int number = 1; number <= 3; number++) {
            if (canWinNimRecursive(n - number, !myTurn)) {
                return true;
            }
        }

        return false;
    }

}
