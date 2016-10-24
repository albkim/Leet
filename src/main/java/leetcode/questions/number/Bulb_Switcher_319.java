package leetcode.questions.number;

/**
 There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb.
 On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on).
 For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.

 Example:

 Given n = 3.

 At first, the three bulbs are [off, off, off].
 After first round, the three bulbs are [on, on, on].
 After second round, the three bulbs are [on, off, on].
 After third round, the three bulbs are [on, off, off].

 So you should return 1, because there is only one bulb is on.

 --------------------------------------------------------------------------------

 If you consider 6th bulb, it is on at first, touched at 2, 3, 6. So only toggled at the factors of 6.
 For 7, only at 7.

 Also notice if it was touched even times, it will be on...if odd, it will be off.

 So only the ones that are touched event times (number of factors other than 1 is even). Only perfect square numbers.

 2^2 = 4 -> 2, 4
 3^3 = 9 -> 3, 9

 Number of perfect square number under a number is equal to square root of the number...

 Take 16...sqrt(16) = 4. Number of perfect square number are 1^2, 2^2, 3^3, 4^4 since 5^5 is 25

 */
public class Bulb_Switcher_319 {

    public static int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }

}
