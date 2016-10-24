package leetcode.questions.bits;

/**
 Divide two integers without using multiplication, division and mod operator.

 If it is overflow, return MAX_INT.

 Looks like the way to do this is a binary long division

 10101 / 11 = 111
      00111
 11   10101
       11
       1001
        11
         11
         11
 */
public class Divide_Two_Integers_29 {

    public static int divide(int dividend, int divisor) {
        // edge case
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }

        if (dividend == divisor) {
            return 1;
        }

        boolean negative = false;
        long lDivident = (long)dividend;
        if (lDivident < 0) {
            lDivident = ~lDivident + 1;
            negative = true;
        }
        long lDivisor = (long)divisor;
        if (lDivisor < 0) {
            lDivisor = ~lDivisor + 1;
            negative = !negative;
        }

        // find the digit where divisor becomes large than dividend
        // 10101 / 11
        // 10101 < 11000
        long current = 1;
        while(lDivident >= lDivisor) {
            lDivisor <<= 1;
            current <<= 1;
        }

        // now digit we need is one right shift
        // 10101 / 1100
        lDivisor >>= 1;
        current >>= 1;

        long answer = 0;
        while(current > 0) {
            if (lDivident >= lDivisor) {
                // if dividend is greater than current divisor (10101 / 1100), then add to the answer 1
                lDivident -= lDivisor;
                answer |= current;
            }
            // shift down the divisor and current (110)
            lDivisor >>= 1;
            current >>= 1;
        }

        answer = negative ? (~answer + 1) : answer;

        if ((answer < Integer.MIN_VALUE) || (answer > Integer.MAX_VALUE)) {
            return Integer.MAX_VALUE;
        }
        return (int)answer;
    }

}
