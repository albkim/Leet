package leetcode.questions.pointer_scan;

/**
 Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Update (2015-02-12):
 For C programmers: Try to solve it in-place in O(1) space.

 What constitutes a word?
 A sequence of non-space characters constitutes a word.

 Could the input string contain leading or trailing spaces?
 Yes. However, your reversed string should not contain leading or trailing spaces.

 How about multiple spaces between two words?
 Reduce them to a single space in the reversed string.


 ---------------------------------------------------------------------------

 Standard question, reverse all chars, and then just reverse the words again

 */
public class Reverse_Words_String_151 {

    public static String reverseWords(String s) {
        if (s == null) {
            return null;
        }

        if (s.length() <= 1) {
            return s.trim();
        }

        char[] chrs = s.toCharArray();
        reverseWords(chrs, 0, s.length() - 1);

        int previous = 0;
        for (int index = 0; index < chrs.length; index++) {
            if (chrs[index] == ' ') {
                if (index > 0) {
                    reverseWords(chrs, previous, index - 1);
                }
                previous = index + 1;
            }
        }

        // last word
        if (previous < s.length()) {
            reverseWords(chrs, previous, s.length() - 1);
        }

        // now i need to reduce the spaces...lol
        StringBuilder newString = new StringBuilder();
        for (int index = 0; index < chrs.length; index++) {
            if (chrs[index] == ' ') {
                if ((newString.length() == 0) || (newString.charAt(newString.length() - 1) == ' ')) {
                    continue;
                }
            }
            newString.append(chrs[index]);
        }
        if ((newString.length() > 1) && (newString.charAt(newString.length() - 1) == ' ')) {
            newString.deleteCharAt(newString.length() - 1);
        }
        return newString.toString();
    }

    private static void reverseWords(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;

            start++;
            end--;
        }
    }
}
