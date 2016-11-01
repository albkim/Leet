package leetcode.questions.bits;

/**
 Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.

 Note:
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

 ----------------------------------------------------------------------------------------------------------

 Not even sure what this is asking for. Is it asking for missing number in continuous sequence...Based on difficulty,
 doesn't seem that easy.

 Seems like it's asking if the array matches 0 - n sequence and if not what's the gap

 lol...kinda figuring out what it's asking for as I run the test cases. The input could be out of order (1, 0). Keep
 doing these stupid questions so I can track the ones I did and one I did not...This guy must really like bits...

 Seems like we can use an array of int to count how many times a particular bit is found in the numbers.
 If the number is below normal we know the number missing has those bits

 1 = 0
 2 = 1
 3 = 1, 0
 4 = 2
 5 = 2, 0
 6 = 2, 1
 7 = 2, 1, 0
 8 = 3
 9 = 3, 0
 10 = 3, 2
 11 = 3, 2, 0
 */
public class Missing_Number_268 {

    public static int missingNumber(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

        boolean zeroSeen = false;
        int[] bits = new int[31];
        int highest = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num == 0) {
                zeroSeen = true;
            }
            highest = Math.max(highest, num);

            int bit = 0;
            int number = num;
            while(number > 0) {
                if ((number & 1) == 1) {
                    bits[bit]++;
                }
                number >>= 1;
                bit++;
            }
        }

        // now reference
        for (int num = 0; num <= highest; num++) {
            int bit = 0;
            int number = num;
            while(number > 0) {
                if ((number & 1) == 1) {
                    bits[bit]--;
                }
                number >>= 1;
                bit++;
            }
        }

        int missingNumber = 0;
        for (int bit = 0; bit < bits.length; bit++) {
            if (bits[bit] < 0) {
                missingNumber |= (1 << bit);
            }
        }

        if (missingNumber > 0) {
            return missingNumber;
        }

        // if we cannot find it, it's either 0 or highest number
        if (!zeroSeen) {
            return 0;
        }
        return highest + 1;
    }

}
