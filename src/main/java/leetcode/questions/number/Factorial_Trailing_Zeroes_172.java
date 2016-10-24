package leetcode.questions.number;

/**
 Given an integer n, return the number of trailing zeroes in n!.

 Note: Your solution should be in logarithmic time complexity.


 ----------------------------------------------------------
 1 x 2 = 2
 2 x 3 = 6
 6 x 4 = 24
 24 x 5 = 120
 120 x 6 = 720
 720 x 7 = 4320
 4320 x 8 = 43560

 looks like we get additional trailing 0 when we get 5, 10, 15 and etc

 The problem comes if we hit power of 5 like 25...

 */
public class Factorial_Trailing_Zeroes_172 {

    public static int trailingZeroes(int n) {
        int count = 0;

        while (n > 0) {
            n /= 5;
            count += n;
        }

        return count;
    }

}
