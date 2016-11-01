package leetcode.questions.pointer_scan;

/**
 Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000,
 and there exists one unique longest palindromic substring.

 palindrome has two forms

 xax and xx

 so we just need to examine as we scan the string left to right

 O(n^2)

 Brute force is O(n^3)
 */
public class Longest_Palindromic_Substring_5 {

    private static class PalindromeResult {
        public int length;
        public int leftIndex;
        public int rightIndex;
    }

    public static String longestPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        if (s.length() == 0) {
            return "";
        }

        String normalized = s.toLowerCase();

        PalindromeResult maxResult = new PalindromeResult();

        for (int index = 0; index < s.length(); index++) {
            if ((index > 0) && (index < (s.length() - 1))) {
                // we can do xax format
                PalindromeResult result = findLongest(normalized, index, index);
                if (result.length > maxResult.length) {
                    maxResult = result;
                }
            }
            if (index < (s.length() - 1)) {
                // we can do xx
                PalindromeResult result = findLongest(normalized, index, index + 1);
                if (result.length > maxResult.length) {
                    maxResult = result;
                }
            }
        }

        return s.substring(maxResult.leftIndex, maxResult.rightIndex + 1);
    }

    private static PalindromeResult findLongest(String s, int leftStart, int rightStart) {
        PalindromeResult result = new PalindromeResult();
        do {
            if (isPalindrome(s, leftStart, rightStart)) {
                result.leftIndex = leftStart;
                result.rightIndex = rightStart;
                result.length = result.rightIndex - result.leftIndex + 1;
                leftStart--;
                rightStart++;
            }
            else {
                break;
            }
        }
        while((leftStart >= 0) && (rightStart <= (s.length() - 1)));

        return result;
    }

    private static boolean isPalindrome(String s, int leftIndex, int rightIndex) {
        return s.charAt(leftIndex) == s.charAt(rightIndex);
    }
}
