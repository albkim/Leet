package leetcode.questions.number;

/**
 Write a program to find the nth super ugly number.

 Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32]  is the sequence of the first 12 super
 ugly numbers given primes = [2, 7, 13, 19] of size 4.

 Note:
 (1) 1 is a super ugly number for any given primes.
 (2) The given numbers in primes are in ascending order.
 (3) 0 < k ? 100, 0 < n ? 106, 0 < primes[i] < 1000.

 ---------------------------------------------------------------------------------------------------------------

 Seems similar to ugly number 2...

 12
 [2,7,13,19]

 1, 2, 7, 13, 19 <- 1*2, 1*7, 1*13, 1*19
 2, 4, 7, 13, 19 <- 2*2, 2*7, 2*13, 2*19
 4, 7, 13, 14, 19, 26, 38 <- 4*2, 4*7, 4*13, 4*19
 8, 13, 14, 19, 26, 28, 52, 76 <-
 */
public class Super_Ugly_Number_313 {

    public static int nthSuperUglyNumber(int n, int[] primes) {
        if(n <= 0 || primes == null || primes.length == 0) {
            return 0;
        }

        int[] ugly = new int[n];
        ugly[0] = 1;
        int length = primes.length;
        int[] indexes = new int[length];
        int[] factors = new int[length];
        for(int i = 0; i < length; ++i) {
            factors[i] = primes[i];
        }
        int curMin = 1;
        for(int i = 1; i < n; i++){
            curMin = factors[0];
            for(int j = 1; j < length; ++j) {
                curMin = Math.min(curMin, factors[j]);
            }
            ugly[i] = curMin;
            for(int j = 0; j < length; ++j) {
                if(curMin == factors[j]) {
                    factors[j] = primes[j] * ugly[++indexes[j]];
                }
            }
        }
        return ugly[n-1];

    }

}
