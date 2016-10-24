package leetcode.questions.dp;

/**
 Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

 Example: Given n = 2, return 91. (The answer should be the total numbers in the range
 of 0 ≤ x < 100, excluding[11,22,33,44,55,66,77,88,99])

 for n = 3
 111, 222, 333, 444, 555, 666, 777, 888, 999
 122, 211
 133, 233
 144....

 Seems like it can be done based on previous calculation

 f(1) = 10 different combinations
 f(2) = 9 * 9 - if we pick a number, the second digit only has 9 unique choices
 f(3) = 9 * 9 * 8 - if we pick 2 numbers, the third digit can only have 8 numbers to choose from to be unique
 f(10) = cannot have unique numbers since we used up every single digit
 */
public class Count_Numbers_Unique_Digits_357 {

    public Count_Numbers_Unique_Digits_357() {
        super();
    }

    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }

        int unique = 0;

        int[] dp = new int[n];

        dp[0] = 10;
        if (n > 1) {
            dp[1] = 81;
        }

        for (int index = 2; index < Math.min(n, 10); index++) {
            dp[index] = dp[index - 1] * (10 - index);
        }

        for (int index = 0; index < Math.min(n, 10); index++) {
            unique += dp[index];
        }

        return unique;
    }

}
