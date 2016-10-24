package leetcode.questions.bits;

/**
 Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:
 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 ...
 53 -> BA

 ------------------------------------------------------------------------------------------------

 Seems like every power of 26, We can use it like bits

 */
public class Excel_Sheet_Column_Title_168 {

    public static String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            result.insert(0, (char)((n - 1) % 26 + 'A'));
            n = (n - 1) / 26;
        }
        return result.toString();
    }

}
