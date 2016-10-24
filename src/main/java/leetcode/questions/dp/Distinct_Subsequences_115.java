package leetcode.questions.dp;

/**
 Given a string S and a string T, count the number of distinct subsequences of T in S.

 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
 of the characters without disturbing the relative positions of the remaining characters.
 (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

 Here is an example:
 S = "rabbbit", T = "rabbit"

 Return 3.

 ------------------------------------------------------------------------------------------------------------

 Seems like a classic DP question

            R   A   B   B   B   I   T
        1   1   1   1   1   1   1   1
    R   0   1   1   1   1   1   1   1
    A   0   0   1   1   1   1   1   1
    B   0   0   0   1   2   3   3   3
    B   0   0   0   0   1   3   3   3
    I   0   0   0   0   0   0   3   3
    T   0   0   0   0   0   0   0   3

 if s(i) != t(j) then dp[j][i] = dp[j][i - 1]
    this is obvious, we cannot do better if this char doesn't match. e.g. t = R and s = RA, at A, it's same as at R

 if s(i) == t(j) then dp[j][i] = dp[j][i - 1] + dp[j - 1][i - 1]
    t = ee, s = eee. at the last one
    f(e, ee) = 2 -> e?e with ee & ?ee with ee
    f(ee, ee) = 1 -> ee? with ee
    so total of 3
 */
public class Distinct_Subsequences_115 {

    public static int numDistinct(String s, String t) {
        if ((s == null) || (t == null) || (s.length() < t.length()) || (s.length() == 0) || (t.length() == 0)) {
            return 0;
        }

        int[][] dp = new int[t.length() + 1][s.length() + 1];

        // init with first
        for (int index = 0; index <= s.length(); index++) {
            dp[0][index] = 1;
        }

        for (int tIndex = 1; tIndex <= t.length(); tIndex++) {
            for (int sIndex = tIndex; sIndex <= s.length(); sIndex++) {
                if (t.charAt(tIndex - 1) == s.charAt(sIndex - 1)) {
                    // take the previous max permutation
                    dp[tIndex][sIndex] += dp[tIndex - 1][sIndex - 1];
                }

                dp[tIndex][sIndex] += dp[tIndex][sIndex - 1];
            }
        }

        return dp[t.length()][s.length()];
    }

}
