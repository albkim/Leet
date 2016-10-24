package leetcode.questions.bits;

/**
 Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".

 */
public class Add_Binary_67 {

    public static String addBinary(String a, String b) {
        int carry = 0;
        int left = a.length() - 1;
        int right = b.length() - 1;

        StringBuilder answer = new StringBuilder();

        while((left >= 0) || (right >= 0) || (carry > 0)) {
            int leftNum = 0;
            if (left >= 0) {
                leftNum = (a.charAt(left) == '1') ? 1 : 0;
                left--;
            }

            int rightNum = 0;
            if (right >= 0) {
                rightNum = (b.charAt(right) == '1') ? 1 : 0;
                right--;
            }

            int sum = carry + leftNum + rightNum;
            answer.insert(0, sum % 2);
            carry = sum / 2;
        }

        return answer.toString();
    }

}
