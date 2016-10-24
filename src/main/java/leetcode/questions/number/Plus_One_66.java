package leetcode.questions.number;

/**
 Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.


 -------------------------------------------------------------------------------------------


 Seems like a simple carry logic

 */
public class Plus_One_66 {

    public static int[] plusOne(int[] digits) {
        int carry = 1;
        for (int index = digits.length - 1; index >= 0; index--) {
            int sum = digits[index] + carry;
            digits[index] = sum % 10;
            carry = sum / 10;
            if (sum < 10) {
                break;
            }
        }

        int[] answer = (carry > 0) ? new int[digits.length + 1] : digits;
        if (carry > 0) {
            // need a new array since it's greater than what's available
            answer[0] = carry;
            for (int index = 0; index < digits.length; index++) {
                answer[index + 1] = digits[index];
            }
        }

        return answer;
    }

}
