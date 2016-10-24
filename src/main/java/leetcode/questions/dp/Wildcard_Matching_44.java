package leetcode.questions.dp;

/**
 Implement wildcard pattern matching with support for '?' and '*'.
 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") ? false
 isMatch("aa","aa") ? true
 isMatch("aaa","aa") ? false
 isMatch("aa", "*") ? true
 isMatch("aa", "a*") ? true
 isMatch("ab", "?*") ? true
 isMatch("aab", "c*a*b") ? false
 */
public class Wildcard_Matching_44 {

    /*
               j -> a    b     *    c    d    ?    i    *    d    e
          i    T    F    F     F    F    F    F    F    F    F    F
          a    F    T    F     F    F    F    F    F    F    F    F
          b    F    F    T     T    F    F    F    F    F    F    F
          e    F    F    F     T
          f    F    F    F     T
          c    F    F          T    T
          d    F    F          T    F    T
          g    F    F          T    F    F    T
          i    F    F          T    F    F    F    T    T    F
          e    F    F          T                        T    F
          s    F    F          T                        T
          c    F    F          T                        T
          d    F    F          T                        T
          f    F    F          T                        T
          i    F    F          T                        T
          m    F    F          T                        T
          d    F    F          T                        T    T
          e    F    F          T                        T         T
     */
    public static boolean isMatch(String s, String p) {
        // lookup of all matches up to i (string) & j (pattern)
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        // dp[0][0] = true -> very basic case when both are empty;
        dp[0][0] = true;

        // dp[i][0] -> all false since pattern is 0...string has to be 0, use default of array

        // dp[0][j] -> false unless j is *, since it could be repeating, do this until non * is encountered
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) != '*') {
                break;
            }
            dp[0][j] = true;
        }

        //now we just build up the dp, two simple cases
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    // we need to consider two cases, 0 occurrence or multiple
                    dp[i][j] = dp[i-1][j] /* 0 occurrence */ || dp[i][j-1] /* ignore current char, 1+ occurrence */;
                }
                else {
                    // previous result with current char comparison; either equal or wild card
                    dp[i][j] = dp[i-1][j-1] && ((s.charAt(i - 1) == p.charAt(j - 1)) || (p.charAt(j - 1) == '?'));
                }
            }
        }

        return dp[s.length()][p.length()];
    }

}
