package leetcode.questions.pointer_scan;

/**
 Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".

 Note:
 The vowels does not include the letter "y".

 --------------------------------------------------------------------------------------------------

 Seems like simple two pointer scan/swap

 */
public class Reverse_Vowels_String_345 {

    public static String reverseVowels(String s) {
        if ((s == null) || (s.length() == 0)) {
            return s;
        }

        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while(left < right) {
            while((left < chars.length) && (!isVowel(chars[left]))) {
                left++;
            }
            while((right >= 0) && (!isVowel(chars[right]))) {
                right--;
            }

            if (left < right) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }
        }

        return new String(chars);
    }

    private static boolean isVowel(char chr) {
        return (chr == 'a') || (chr == 'e') || (chr == 'i') || (chr == 'o') || (chr == 'u') ||
                (chr == 'A') || (chr == 'E') || (chr == 'I') || (chr == 'O') || (chr == 'U');
    }

}
