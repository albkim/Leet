package leetcode.questions.array;

/**
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

 Note:
 You can assume that you can always reach the last index.

 -----------------------------------------------------------------------------------------------------

 Looks like the solution is a greedy solution which tries to find the maximum index to jump from all the positions
 the current index can reach and taking it. (Since we are guaranteed to win)

 */
public class Jump_Game_II_45 {

    public static int jump(int[] nums) {
        // what if I try greedy since it's guaranteed that there is a solution.

        // try to go as far as I can and try to find the max jump.
        int index = 0;
        int jump = 0;
        while (index < nums.length - 1) {
            int candidate = nums[index];
            int boundary = Math.min(index + candidate, nums.length - 1);

            // need to consider self first before jumping...
            if (boundary == nums.length - 1) {
                jump++;
                break;
            }

            int maxJump = Integer.MIN_VALUE;
            int maxJumpIndex = -1;
            for (int sIndex = boundary; sIndex > index ; sIndex--) {
                int destination = nums[sIndex] + sIndex;
                if (destination > maxJump) {
                    maxJump = destination;
                    maxJumpIndex = sIndex;
                }
            }

            jump++;
            index = maxJumpIndex;
        }

        return jump;
    }

}
