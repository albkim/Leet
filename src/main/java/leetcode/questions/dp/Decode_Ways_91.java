package leetcode.questions.dp;

/**
 A message containing letters from A-Z is being encoded to numbers using the following mapping:
 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26


 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.

 --------------------------------------------------------------------------------------------------------

 Similar to break word, we can try all variations and turn that into DP

 */
public class Decode_Ways_91 {

    public static int numDecodings(String s) {
        return numDecodingsDP(s);
        //return numDecodingsRecursive(s, 0);
    }

    private static int numDecodingsDP(String s) {
        if ((s.length() == 0) || (s.equals("0"))) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];

        dp[s.length()] = 1;

        for (int index = s.length() - 1; index >= 0; index--) {
            if (s.charAt(index) != '0') {
                int count = dp[index + 1];
                if ((index + 1 < s.length()) && (Integer.parseInt(s.substring(index, index + 2)) <= 26)) {
                    count += dp[index + 2];
                }
                dp[index] = count;
            }
        }

        return dp[0];
    }

    private static int numDecodingsRecursive(String s, int index) {
        if ((s == "") || (s.equals("0"))) {
            return 0;
        }

        // if we are done, return count
        if (index == s.length()) {
            return 1;
        }

        int ways = 0;
        if (s.charAt(index) != '0') {
            ways += numDecodingsRecursive(s, index + 1);
            if ((index + 1 < s.length()) && (Integer.parseInt(s.substring(index, index + 2)) <= 26)) {
                // see if taking two character can produce additional pattern
                ways += numDecodingsRecursive(s, index + 2);
            }
        }
        return ways;
    }

}
