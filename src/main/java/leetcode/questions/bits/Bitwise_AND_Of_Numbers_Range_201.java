package leetcode.questions.bits;

/**
 Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

 For example, given the range [5, 7], you should return 4.

 -------------------------------------------------------------------------------------------------------------

 Not sure what the trick is...Just looked at the answer. Not even sure what's the point of these questions...
 Total waste of time...

 if m != n then there is one odd and one even. It means 1 or 0 at the end, when you AND that, it's always 0
 Now as we shift both numbers right by 1, if the numbers are still different, then the different is enough
 to do another odd/even. So we can keep doing this until they are the same. Now we have all the 1's which can
 be AND'ed to get 1. We need to shift this number left by the number of right shift we did.

 */
public class Bitwise_AND_Of_Numbers_Range_201 {

    public static int rangeBitwiseAnd(int m, int n) {
        if ((m == 0) || (m == n)) {
            return m;
        }

        int leftShift = 1;
        while(m != n) {
            m >>= 1;
            n >>= 1;
            leftShift <<= 1;
        }
        return m * leftShift;
    }

}
