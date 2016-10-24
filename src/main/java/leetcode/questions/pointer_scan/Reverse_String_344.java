package leetcode.questions.pointer_scan;

/**
 Write a function that takes a string as input and returns the string reversed.

 Example:
 Given s = "hello", return "olleh".

 ---------------------------------------------------------------------------------

 Simple swap
 */
public class Reverse_String_344 {

    public static String reverseString(String s) {
        if ((s == null) || (s.length() == 0)) {
            return s;
        }

        char[] chrs = s.toCharArray();

        int left = 0;
        int right = chrs.length - 1;

        while(left < right) {
            char tmp = chrs[left];
            chrs[left] = chrs[right];
            chrs[right] = tmp;

            left++;
            right--;
        }

        return new String(chrs);
    }

}
