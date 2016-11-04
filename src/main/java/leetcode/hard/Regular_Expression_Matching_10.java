package leetcode.hard;

/**
 Implement regular expression matching with support for '.' and '*'.
 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") ? false
 isMatch("aa","aa") ? true
 isMatch("aaa","aa") ? false
 isMatch("aa", "a*") ? true
 isMatch("aa", ".*") ? true
 isMatch("ab", ".*") ? true
 isMatch("aab", "c*a*b") ? true
 */
public class Regular_Expression_Matching_10 {

    /*
            j -> a    b    *    a    c    *    a
        i   T    F    F    F    F    F    F    F
        a   F    T    F    T    F    F    F    F
        a   F    F    F    F    T    F    T    F
        a   F    F    F    F    F    F    F    T

            j -> c    *    a    *    b
        i   T    F    T    F    T    F
        a   F    F    F    T    T    F
        a   F    F    F    F    T    F
        b   F    F    F    F    F    T
     */
    public static boolean isMatch(String s, String p) {
        // lookup of all matches up to i (string) & j (pattern)
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        // dp[0][0] = true -> very basic case when both are empty;
        dp[0][0] = true;

        // dp[i][0] -> all false since pattern is 0...string has to be 0, use default of array

        // dp[0][j] -> false unless j - 1 is * and there is a char infront of it. Then the value should be j - 2
        for (int j = 1; j <= p.length(); j++) {
            if ((j - 2 >= 0) && (p.charAt(j - 1) == '*')) {
                dp[0][j] = dp[0][j - 2];
            }
        }

        //now we just build up the dp, two simple cases
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if ((p.charAt(j - 1) == '*') && (j - 2 >= 0)) {
                    if ((s.charAt(i - 1) == p.charAt(j - 2)) || (p.charAt(j - 2) == '.')) {
                        // consider matching case
                        dp[i][j] = dp[i][j - 2] /* 0 occurrence */
                                || dp[i - 1][j] /* ignore current char, 1+ occurrence */;
                    }
                    else {
                        // consider 0 case
                        dp[i][j] = dp[i][j - 2];
                    }
                }
                else {
                    // previous result with current char comparison; either equal or wild card
                    dp[i][j] = dp[i-1][j-1] && ((s.charAt(i - 1) == p.charAt(j - 1)) || (p.charAt(j - 1) == '.'));
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
