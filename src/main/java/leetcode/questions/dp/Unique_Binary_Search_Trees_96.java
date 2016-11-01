package leetcode.questions.dp;

/**
 Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 For example,
 Given n = 3, there are a total of 5 unique BST's.
 1         3     3      2      1
 \       /     /      / \      \
  3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3


 -------------------------------------------------------------------------------------------------

 One of the characteristics of binary search tree is that all the numbers to the left has to be smaller and
 all the numbers to the right has to be larger. Then we can break this to a sub problems of all possible combinations
 of left * all possible combinations of right. Then we can also sum up all combinations as each number becomes the root

 when there is
 1 node, there is only 1 variation
 2 node, there is only one when 1st is root, and one when 2nd is root. giving total of 2
 3 node, total of 5
    1 (2 numbers to the right, meaning there are 2 combinations)
    2 (1 on each side, 1 * 1 = 1)
    3 (2 numbers to the left, meaning there are 2 combinations)

 */
public class Unique_Binary_Search_Trees_96 {

    public static int numTrees(int n) {
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];

        dp[0] = 1;
        for (int combination = 2; combination <= n; combination++) {
            int total = 0;
            for (int numbers = 1; numbers <= combination; numbers++) {
                int numbersLeft = numbers - 1;
                int combinationLeft = (numbersLeft == 0) ? 1 : dp[numbersLeft - 1];
                int numbersRight = combination - numbers;
                int combinationRight = (numbersRight == 0) ? 1 : dp[numbersRight - 1];

                total += combinationLeft * combinationRight;
            }
            dp[combination - 1] = total;
        }

        return dp[n - 1];
    }

}
