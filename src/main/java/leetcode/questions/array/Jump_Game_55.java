package leetcode.questions.array;

/**
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.


 -------------------------------------------------------------------------------------------------------

 Seems like the false case is where I try everything and just cannot advance. Since all numbers are positive
 I have to make progress unless the best i can do is land on 0 in which case the game is not winnable

 This is not a backtracking problem. It does something smarter. Pick a number and find the maximum I can jump to.
 If I hit 0, then try all other ones in front to see if I can get past 0. If not, I cannot win.

 Wonder if I can do something even smart. As I scan left to right. Why not just keep the maximum index reached. If it's
 at any point equals to current. I cannot advance more? Works!

 */
public class Jump_Game_55 {

    public static boolean canJump(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return true;
        }

        int maxIndex = Integer.MIN_VALUE;
        for (int index = 0; index < nums.length; index++) {
            maxIndex = Math.max(maxIndex, nums[index] + index);
            if ((maxIndex == index) && (maxIndex != nums.length - 1)) {
                return false;
            }
        }

        return true;
    }

    private static boolean canJumpLong(int[] nums) {
        boolean winnable = true;

        int index = 0;
        while(index < nums.length) {
            int candidate = nums[index];
            int boundary = index + candidate;

            if (boundary >= (nums.length - 1)) {
                return true;
            }

            // within the boundary find the best point
            boolean jumped = false;
            int maxJumpValue = Integer.MIN_VALUE;
            for (int jumpIndex = index + 1; jumpIndex <= boundary; jumpIndex++) {
                int jumpValue = jumpIndex + nums[jumpIndex];
                if (jumpValue > maxJumpValue) {
                    maxJumpValue = jumpValue;
                    index = jumpIndex;
                    jumped = true;
                }
            }

            if (!jumped) {
                return false;
            }
        }

        return winnable;
    }

}


