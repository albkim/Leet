package leetcode.questions.number;

/**
 Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 Seems like string reverse would work...or some clever math with 10's
 */
public class Reverse_Integer_7 {

    public static int reverse(int x) {
        long result = 0;

        boolean negative = (x < 0);
        long cleaned = x < 0 ? -1 * (long)x : x;

        do {
            // signed integer size
            if ((result * 10) + (cleaned % 10) > Integer.MAX_VALUE) {
                return 0;
            }
            result = (result * 10) + (cleaned % 10);
            cleaned /= 10;
        }
        while (cleaned != 0);

        if (negative) {
            result *= -1;
        }

        return (int)result;
    }

}
