package leetcode.questions.bits;

/**
 Related to question Excel Sheet Column Title

 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:
 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28

 -----------------------------------------------------------------------------------------------------

 This is also a bits question. Each letter can be converted to bits and added.

 */
public class Excel_Sheet_Column_Number_171 {

    public static int titleToNumber(String s) {
        int bit = 0;

        int bitCount = 0;
        for (int index = s.length() - 1; index >= 0; index--) {
            bit += ((s.charAt(index) - 'A') + 1) * Math.pow(26, bitCount);
            bitCount++;
        }

        return bit;
    }

}
