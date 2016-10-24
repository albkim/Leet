package leetcode.questions.number;

/**
 Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

 For example,

 123 -> "One Hundred Twenty Three"
 12345 -> "Twelve Thousand Three Hundred Forty Five"
 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

 ------------------------------------------------------------------------------------------------------------------

 We just have to do some clever lookup to account for irregular numbers and clever modulus

 */
public class Integer_English_Words_273 {

    private static String[] ones = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    private static String[] teens = new String[] {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};
    private static String[] tens = new String[] {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        else if (num >= 1000000000) {
            return combine(numberToWords(num / 1000000000), "Billion", numberToWords(num % 1000000000));
        }
        else if (num >= 1000000) {
            return combine(numberToWords(num / 1000000), "Million", numberToWords(num % 1000000));
        }
        else if (num >= 1000) {
            return combine(numberToWords(num / 1000), "Thousand", numberToWords(num % 1000));
        }
        else if (num >= 100) {
            return combine(numberToWords(num / 100), "Hundred", numberToWords(num % 100));
        }
        else if (num <= 10) {
            return ones[num];
        }
        else if (num <= 20) {
            return teens[num - 10];
        }
        else {
            return combine(tens[num / 10], "", ones[num % 10]);
        }
    }

    private static String combine(String left, String unit, String right) {
        StringBuilder result = new StringBuilder();
        result.append(left);

        if (unit.length() > 0) {
            result.append(" ");
            result.append(unit);
        }

        if ((right.length() > 0) && (!right.equals("Zero"))) {
            result.append(" ");
            result.append(right);
        }

        return result.toString();
    }

}
