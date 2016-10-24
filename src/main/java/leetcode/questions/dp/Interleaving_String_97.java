package leetcode.questions.dp;

/**
 Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",

 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.

 -----------------------------------------------------------------------------------------------------------

 Seems like similar to word break except it's letters and there are two strings interleaved

 */
public class Interleaving_String_97 {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        return isInterleaveDP(s1, s2, s3);
        //return isInterleaveRecursive(s1, s2, s3, 0, 0, 0);
    }

    /*
        Similar to work break, initialize with base (0 index) and try all combination of i,j
        cbb
                b
            T   F
        d   F   F
        b   F   F
     */
    private static boolean isInterleaveDP(String s1, String s2, String s3) {
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        dp[0][0] = true;
        for (int s1Index = 0; s1Index < s1.length(); s1Index++) {
            dp[s1Index + 1][0] = s1.charAt(s1Index) == s3.charAt(s1Index) && dp[s1Index][0];
        }
        for (int s2Index = 0; s2Index < s2.length(); s2Index++) {
            dp[0][s2Index + 1] = s2.charAt(s2Index) == s3.charAt(s2Index) && dp[0][s2Index];
        }

        for (int s1Index = 0; s1Index < s1.length(); s1Index++) {
            for (int s2Index = 0; s2Index < s2.length(); s2Index++) {
                int s3Index = s1Index + s2Index + 1;
                dp[s1Index + 1][s2Index + 1] = ((s1.charAt(s1Index) == s3.charAt(s3Index)) && dp[s1Index][s2Index + 1]) ||
                        ((s2.charAt(s2Index) == s3.charAt(s3Index)) && dp[s1Index + 1][s2Index]);
            }
        }

        return dp[s1.length()][s2.length()];
    }

    private static boolean isInterleaveRecursive(String s1, String s2, String s3, int s1Index, int s2Index, int s3Index) {
        if ((s1Index == s1.length()) && (s2Index == s2.length()) && (s3Index == s3.length())) {
            return true;
        }

        if ((s1Index < s1.length()) && (s1.charAt(s1Index) == s3.charAt(s3Index))) {
            if (isInterleaveRecursive(s1, s2, s3, s1Index + 1, s2Index, s3Index + 1)) {
                return true;
            }
        }
        if ((s2Index < s2.length()) && (s2.charAt(s2Index) == s3.charAt(s3Index))) {
            if (isInterleaveRecursive(s1, s2, s3, s1Index, s2Index + 1, s3Index + 1)) {
                return true;
            }
        }

        return false;
    }

}
