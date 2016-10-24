package leetcode.questions.back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return
 [
 ["aa","b"],
 ["a","a","b"]
 ]

-------------------------------------------------------------------------------------------------------

 as we traverse from left to right, if it's a palindrome, backtrack

 No need for dp since they want all variations, we just have to traverse

 */
public class Palindrome_Partitioning_131 {

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        if ((s == null) || (s.length() == 0)) {
            return result;
        }

        backtrack(result, s, s.toCharArray(), 0, new ArrayList<>());

        return result;
    }

    private static void backtrack(List<List<String>> result, String s, char[] chrs, int start, List<String> current) {
        if (start == chrs.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int index = start; index < chrs.length; index++) {
            if (isPalindrome(chrs, start, index)) {
                String candidate = s.substring(start, index + 1);
                current.add(candidate);
                backtrack(result, s, chrs, index + 1, current);
                current.remove(current.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(char[] s, int start, int end) {
        while(start <= end) {
            if (s[start] != s[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

}
