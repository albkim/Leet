package leetcode.questions.dp;

/**
 Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character



 ---------------------------------------------------------------------------------------------------------------


 This can be done recursively or using dp.

 Recursively is simple: from the back, take the min cost of
    Replace - Current char cost + cost of each string - 1
    Delete - 1 + cost of string1 - 1 and string 2
    Add - 1 + cost of string1 and string2 - 1

    Base condition - if length of one string is 0, cost is equal to length of the other string

 DP - 2D array with each rectangle showing cost of each substring up to the point
    Each edge is cost of the other string
    Diagonal is comparison of each aligning char

    Saturday & Sunday

            s       a       t       u       r       d       a       y
        0   1       2       3       4       5       6       7       8
    s   1   0       1       2       3       4       5       6       7
    u   2   1       1       2       2       3       4       5       6
    n   3   2       2       2       3       3       4       5       6
    d   4   3       3       3       3       4       3       4       5
    a   5   4       3       4       4       4       4       3       4
    y   6   5       4       4       5       5       5       5       3

 */
public class Edit_Distance_72 {

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int index = 1; index <= word1.length(); index++) {
            dp[index][0] = index;
        }
        for (int index = 1; index <= word2.length(); index++) {
            dp[0][index] = index;
        }

        for (int w1 = 1; w1 <= word1.length(); w1++) {
            for (int w2 = 1; w2 <= word2.length(); w2++) {
                dp[w1][w2] = Math.min(
                        Math.min(
                                1 + dp[w1][w2 - 1],
                                1 + dp[w1 - 1][w2]
                        ),
                        (word1.charAt(w1 - 1) == word2.charAt(w2 - 1) ? 0 : 1) + dp[w1 - 1][w2 - 1]
                );
            }
        }

        return dp[word1.length()][word2.length()];
    }

}
