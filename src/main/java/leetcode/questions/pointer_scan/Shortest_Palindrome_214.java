package leetcode.questions.pointer_scan;

/**
 Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
 Find and return the shortest palindrome you can find by performing this transformation.

 For example:

 Given "aacecaaa", return "aaacecaaa".

 Given "abcd", return "dcbabcd".

 ---------------------------------------------------------------------------------------------------

 Seems like this is a variation of longest palindrome. Since we know it has to end with first char
 we can scan from the end and do palindrome check only if we encounter the same char, and at the first
 hit, we can use that as the right index to add reverse chars

 */
public class Shortest_Palindrome_214 {

    public static String shortestPalindrome(String s) {
        if ((s == null) || (s.length() <= 1)) {
            return s;
        }

        int rightIndex = 1;
        char[] sa = s.toCharArray();
        for (int index = sa.length - 1; index > 0; index--) {
            if ((sa[0] == sa[index]) && (isPalindrome(sa, 0, index))) {
                rightIndex = index + 1;
                break;
            }
        }

        StringBuilder result = new StringBuilder(s);
        for (int index = rightIndex; index < sa.length; index++) {
            result.insert(0, sa[index]);
        }
        return result.toString();
    }

    private static boolean isPalindrome(char[] sa, int left, int right) {
        while((left < right) && (sa[left] == sa[right])) {
            left++;
            right--;
        }

        return ((left >= right) && ((left - right) <= 1));
    }

}
