package leetcode.questions.test.bits;

/**
 Given a non negative integer number num. For every numbers i in the range 0 ? i ? num calculate the
 number of 1's in their binary representation and return them as an array.

 Example:
 For num = 5 you should return [0,1,1,2,1,2].

 Follow up:
 •It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 •Space complexity should be O(n).
 •Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

 ----------------------------------------------------------------------------------------------------------

 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 -> 0, 1, 1, 2, 1, 2, 2, 3, 1,

 If the number is power of 2, then it's always 1. Else, it's remainder + 1

 */
public class Counting_Bits_338 {

    public static int[] countBits(int num) {
        int[] result = new int[num + 1];

        int lastPowerOfTwo = 0;
        for (int number = 1; number <= num; number++) {
            if (isPowerOfTwo(number)) {
                result[number] = 1;
                lastPowerOfTwo = number;
            }
            else {
                int remainder = number - lastPowerOfTwo;
                result[number] = result[remainder] + 1;
            }
        }

        return result;
    }

    private static boolean isPowerOfTwo(int num) {
        return Math.pow(2, 31) % num == 0;
    }

}
