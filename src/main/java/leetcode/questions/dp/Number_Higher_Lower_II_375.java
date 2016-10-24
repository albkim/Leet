package leetcode.questions.dp;

/*

 We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.
 Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
 Example:
 n = 10, I pick 8.

 First round:  You guess 5, I tell you that it's higher. You pay $5.
 Second round: You guess 7, I tell you that it's higher. You pay $7.
 Third round:  You guess 9, I tell you that it's lower. You pay $9.

 Game over. 8 is the number I picked.

 You end up paying $5 + $7 + $9 = $21.

 Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.

 Initial thought is that this is binary search since that way I am guaranteed to win. However I don't think it minimizes
 my loss.
 So Seems like this is game theory algo...minimax algorithm. We need to evaluate all possible combination and pick the
 best approach

 take example of n = 4
 I can pick 1, which makes my pay 1 and i then get another choice between 2-4, now picking 3 ensures i know which direction to go
 making the total cost 4. This is cheaper than binary search which would yield (2, 3) = 5....so seems like this rules out binary search
 Seems like we need to try all variations and figure out the optimum path. Sounds like a good candidate for DP?

 */
public class Number_Higher_Lower_II_375 {

    public static int getMoneyAmountRecursive(int n) {
        return getMoneyAmountRecursiveI(1, n);
    }

    private static int getMoneyAmountRecursiveI(int start, int end) {
        // if we only have 3, game is over...return middle amount this would minimize the player loss
        if ((end - start) == 2) {
            return start + 1;
        }
        // if there are 2 choices, pick lower
        else if ((end - start) == 1) {
            return start;
        }
        // if there is only one, you have won, don't need to spend money
        else if (end == start) {
            return 0;
        }

        int cost = Integer.MAX_VALUE;
        // as a player, i want to take the min of these
        for (int num = start; num <= end; num++) {
            // there are 3 cases
            // player guesses the number the first time
            // lower
            // higher
            // To guarantee a win, i need to assume the worst for the player,
            // I want to take the max of these, since 1 is always 0, take max of lower/higher
            int mostExpDirection = num + Math.max(
                    (num > start) ? getMoneyAmountRecursiveI(1, num - 1) : 0,
                    (num < end) ? getMoneyAmountRecursiveI(num + 1, end) : 0);
            cost = Math.min(cost, mostExpDirection);
        }

        return cost;
    }

    public static int getMoneyAmountDP(int n) {
        // what is a good DP structure
        // how about columns - start, rows - end, so 4, it would look like this?
        //         1        2       3       4
        //  1      0
        //  2      1        0google code jam 2016

        //  3      2        2       0
        //  4               3       3       0
        //
        //  1,4 - min(1 + f(2, 4), 2 + f(3, 4))

        // Now building this up seems a big tricky, in order to fill a range (e.g. 1-4) I need to know all the
        // components that makes up that range. However I build it up by increasing the ranges, the largest
        // would be ultimately the 1-n range

        int[][] matrix = new int[n + 1][n + 1];

        // pre-populate the knowns
        for (int num = 1; num <= n; num++) {
            matrix[num][num] = 0;
            if (num < n) {
                matrix[num][num + 1] = num;
            }
            if (num < (n - 1)) {
                matrix[num][num + 2] = num + 1;
            }
        }

        // already did range 0 - 2
        for (int range = 3; range < n; range++) {
            for (int start = 1; start <= (n - range); start++) {
                int end = start + range;
                int min = Integer.MAX_VALUE;
                for (int num = start; num <= end; num++) {
                    min = Math.min(min, num + Math.max(
                            matrix[start][Math.max(num - 1, start)],
                            matrix[Math.min(num + 1, end)][end]
                    ));
                }
                matrix[start][end] = min;
            }
        }

        return matrix[1][n];
    }

}
