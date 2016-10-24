package leetcode.questions.dp;

import java.util.Set;

/**
 Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated
 sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".


 --------------------------------------------------------------------------------------------------------

 This is the simple backtrack / dp problem. We just need to backtrack each substring and see if its part of the dic
 If we can reach the end, we are good.

 DP should be two index where it's start to end. if I can see current - word length == true, then no need to go further

 */
public class Word_Break_139 {

    public static boolean wordBreak(String s, Set<String> wordDict) {
        if ((s == null) || (s.length() == 0)) {
            return true;
        }

        return wordBreakDP(s, wordDict);
    }

    private static boolean wordBreakDP(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (wordDict.contains(s.substring(i, j + 1))) {
                    if (dp[j + 1]) {
                        dp[i] = dp[j + 1];
                        break;
                    }
                }
            }
        }

        return dp[0];
    }

    private static boolean wordBreakBacktrack(String s, int start, Set<String> wordDict) {
        if (start == s.length()) {
            return true;
        }

        for (int index = start; index < s.length(); index++) {
            if (wordDict.contains(s.substring(start, index + 1))) {
                if (wordBreakBacktrack(s, index + 1, wordDict)) {
                    return true;
                }
            }
        }

        return false;
    }

}
