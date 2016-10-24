package leetcode.questions.pointer_scan;

/**
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.

 */
public class Valid_Palindrome_125 {

    public static boolean isPalindrome(String s) {
        if ((s == null) || (s.length() == 0)) {
            return true;
        }

        return isPalindrome(s.toLowerCase(), 0, s.length() - 1);
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            while((left < s.length()) && (isNotAlphaNumeric(s.charAt(left)))) {
                left++;
            }
            while((right >= 0) && (isNotAlphaNumeric(s.charAt(right)))) {
                right--;
            }
            if (left < right) {
                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                }
                else {
                    return false;
                }
            }
        }
        return ((left == right) || (right < left));
    }

    private static boolean isNotAlphaNumeric(char chr) {
        return (!(((chr >= 'a') && (chr <= 'z')) || ((chr >= 'A') && (chr <= 'Z')) || ((chr >= '0') && (chr <= '9'))));
    }

}
