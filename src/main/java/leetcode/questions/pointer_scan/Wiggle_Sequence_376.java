package leetcode.questions.pointer_scan;

/**
 A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate
 between positive and negative. The first difference (if one exists) may be either positive or negative.
 A sequence with fewer than two elements is trivially a wiggle sequence.

 For example,
 [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative.
 In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences
 are positive and the second because its last difference is zero.

 Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence.
 A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence,
 leaving the remaining elements in their original order.

 Examples: 
 Input: [1,7,4,9,2,5]
 Output: 6
 The entire sequence is a wiggle sequence.

 Input: [1,17,5,10,13,15,10,5,16,8]
 Output: 7
 There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

 Input: [1,2,3,4,5,6,7,8,9]
 Output: 2

 [1, 10, 11, 10, 11, 10]


 -----------------------------------------------------------------------------------------------------------



 seems like when we move in one direction, we want to ignore anything in the same direction
 and take the highest/lowest...shouldn't that give the longest subsequence

 also seems like we always want to include the first number

 the editorial answer has nicer explanation, basically if we were to plot the numbers, what it ends up being is to
 find the local minima and maxima which is the solution here

 */
public class Wiggle_Sequence_376 {

    public static int wiggleMaxLength(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        if (nums.length == 0) {
            return 0;
        }

        int length = 1;
        int previous = nums[0];
        Boolean isUp = null;

        for (int index = 1; index < nums.length; index++) {
            if (nums[index] == previous) {
                // ignore
                continue;
            }

            boolean newUp = nums[index] > previous;
            if (isUp == null) {
                // we are setting the first direction, so doesn't matter
                isUp = newUp;
                length++;
            }
            else {
                // now we are here, either it's the same direction or flipped, so we need to do that eval
                if (isUp.booleanValue() == newUp) {
                    // same direction just in bigger amplitude, we want to replace previous to maximize the chance
                    // of flip
                    previous = nums[index];
                } else {
                    // flipped!
                    length++;
                    isUp = newUp;
                }
            }
            previous = nums[index];
        }

        return length;
    }

}
