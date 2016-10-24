package leetcode.questions.back_tracking;

/**
 Additive number is a string whose digits can form additive sequence.

 A valid additive sequence should contain at least three numbers. Except for the first two numbers,
 each subsequent number in the sequence must be the sum of the preceding two.

 For example:
 "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199. 1 + 99 = 100, 99 + 100 = 199


 Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

 Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

 Follow up:
 How would you handle overflow for very large input integers?

 ------------------------------------------------------------------------------------------------------------

 Try numbers of various length and it should automatically dictate the next number

 */
public class Additive_Number_306 {

    public static boolean isAdditiveNumber(String num) {
        if ((num == null) || (num.length() < 3)) {
            return false;
        }

        return backtrack(num, 0, "0");
    }

    private static boolean backtrack(String num, int start, String previous) {
        for (int index = start; index < num.length(); index++) {
            String number = num.substring(start, index + 1);
            if ((number.length() > 1) && (number.charAt(0) == '0')) {
                continue;
            }
            if (start == 0) {
                // initial case
                if (index < num.length()) {
                    if (backtrack(num, index + 1, number)) {
                        return true;
                    }
                }
            }
            else {
                String answer = add(previous, number);

                // now check if answer is correct
                int answerLength = answer.length();
                if (index + 1 + answerLength <= num.length()) {
                    if (num.substring(index + 1, index + 1 + answerLength).equals(answer)) {
                        // found a successful answer
                        if (index + 1 + answerLength == num.length()) {
                            return true;
                        }
                        if (backtrack(num, index + 1, number)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    private static String add(String left, String right) {
        StringBuilder sbLeft = new StringBuilder(left);
        sbLeft.reverse();

        StringBuilder sbRight = new StringBuilder(right);
        sbRight.reverse();

        int carry = 0;
        StringBuilder answer = new StringBuilder();
        for (int index = 0; index < Math.max(sbLeft.length(), sbRight.length()); index++) {
            int leftDigit = (index < sbLeft.length()) ? Integer.parseInt(String.valueOf(sbLeft.charAt(index))) : 0;
            int rightDigit = (index < sbRight.length()) ? Integer.parseInt(String.valueOf(sbRight.charAt(index))) : 0;

            int sum = leftDigit + rightDigit + carry;

            carry = sum / 10;
            answer.append(sum % 10);
        }

        if (carry > 0) {
            answer.append(carry);
        }

        answer.reverse();
        return answer.toString();
    }

}
