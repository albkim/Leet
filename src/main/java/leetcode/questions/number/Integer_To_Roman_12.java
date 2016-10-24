package leetcode.questions.number;

/**
 Given an integer, convert it to a roman numeral.

 Input is guaranteed to be within the range from 1 to 3999.

 1 I
 2 II
 3 III
 4 IV
 5 V
 6 VI
 7 VII
 8 VIII
 9 IX
 10 X
 40 XL
 50 L
 90 XC
 100 C
 500 D
 1000 M

 123 = CXXIII
 163 = CLXIII
 193 = CXCIII
 324 = CCCXXIV

 think simple...if we know how to represent each digit, it's a simple lookup
 */
public class Integer_To_Roman_12 {

    private static String[] thousands = new String[] {"", "M", "MM", "MMM"};
    private static String[] hundreds = new String[] {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static String[] tens = new String[] {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static String[] ones = new String[] {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public static String intToRoman(int num) {
        return thousands[num / 1000] + hundreds[(num % 1000) / 100] + tens[(num % 100) / 10] + ones[num % 10];
    }

}
