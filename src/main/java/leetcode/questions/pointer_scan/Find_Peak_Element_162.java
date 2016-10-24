package leetcode.questions.pointer_scan;

/**
 A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ? num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -?.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

 ---------------------------------------------------------------------------------------------------------------

 Seems like local maxima search

 */
public class Find_Peak_Element_162 {

    public static int findPeakElement(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return -1;
        }

        if (nums.length == 1) {
            return 0;
        }

        int previous = nums[0];
        Boolean increasing = null;

        for (int index = 1; index < nums.length; index++) {
            // we are guaranteed to not have previous == current
            if (previous < nums[index]) {
                increasing = true;
            }
            else {
                if ((increasing != null) && (increasing.booleanValue())) {
                    // found a maxima
                    return index - 1;
                }
                increasing = false;
            }
            previous = nums[index];
        }

        // if we got here it could be either end
        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        return -1;
    }

}
