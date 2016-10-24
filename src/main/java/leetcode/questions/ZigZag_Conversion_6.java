package leetcode.questions;

/**
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 (you may want to display this pattern in a fixed font for better legibility)
 P   A   H   N
 A P L S I I G
 Y   I   R

 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:
 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

 Realize that first row chars are always n + (n - 1). For 3 rows, it's 1st, 5th
 For second it's (n + 1) 2nd and n + (n - 2) 4th and so on until you get to the middle
 */
public class ZigZag_Conversion_6 {

    public static String convert(String s, int numRows) {
        if (s == null) {
            throw new IllegalArgumentException();
        }

        // edge case, if length <= numRows...or numRows == 1 it should just return string
        if ((s.length() <= numRows) || (numRows == 1)) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        int skip = (2 * numRows) - 2; // extra one since it's the index
        for (int row = 1; row <= numRows; row++) {
            for (int index = 0; index < s.length(); index += skip) {
                // this will iterate through the first line, we just need to do some clever math
                int nextBound = index + skip;
                if (row == 1) {
                    // if first row, just need to add
                    result.append(s.charAt(index));
                }
                else if (row == numRows) {
                    // if last row, just need to add one char which is nth from index
                    int midIndex = index + numRows - 1;
                    if (midIndex< s.length()) {
                        result.append(s.charAt(midIndex));
                    }
                }
                else {
                    // all other rows would have 2 chars in between
                    // left side
                    int leftIndex = index + row - 1;
                    if (leftIndex < s.length()) {
                        result.append(s.charAt(leftIndex));
                    }
                    int rightIndex = nextBound - row + 1;
                    if (rightIndex < s.length()) {
                        result.append(s.charAt(rightIndex));
                    }
                }
            }
        }
        return result.toString();
    }

}
