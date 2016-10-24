package leetcode.questions.bits;

/**
 Given an integer, write a function to determine if it is a power of two.

 ----------------------------------------------------------------------------

 As I shift right, if there is just 1 of 1, then it's power of 2

 */
public class Power_Of_Two_231 {

    public static boolean isPowerOfTwo(int n) {
        while(n > 0) {
            if ((n & 1) == 1) {
                return (n >> 1) == 0;
            }
            n >>= 1;
        }

        return false;
    }

}
