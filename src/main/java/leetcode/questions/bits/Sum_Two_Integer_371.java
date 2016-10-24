package leetcode.questions.bits;

/**

 Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 Example: Given a = 1 and b = 2, return 3.

 Not sure if it has to handle negative
 */
public class Sum_Two_Integer_371 {

    public static int getSum(int a, int b) {
        // do exclusive or...XOR since we need to worry about carry
        // then perform carry by shifting the carry bits (&) left
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }

        return getSum(a ^ b, (a & b) << 1);
    }

}
