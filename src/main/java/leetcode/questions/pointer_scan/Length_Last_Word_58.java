package leetcode.questions.pointer_scan;

/**
 Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 For example,
 Given s = "Hello World",
 return 5.


 -------------------------------------------------------------------------------------------------------------

 Seems like a simple pointer scan, but has things like "a   ". So we need to find a last world...

 */
public class Length_Last_Word_58 {

    public static int lengthOfLastWord(String s) {
        if ((s == null) || (s.length() == 0)) {
            return 0;
        }

        int indexLastSpace = -1;
        int wordIndex = -1;
        boolean wordFound = false;
        for (int index = s.length() - 1; index >= 0; index--) {
            if ((wordFound) && (s.charAt(index) == ' ')) {
                indexLastSpace = index;
                break;
            }
            else if ((!wordFound) && (s.charAt(index) != ' ')) {
                wordFound = true;
                wordIndex = index;
            }
        }

        return wordIndex - indexLastSpace;
    }

}
