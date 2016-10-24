package leetcode.questions.pointer_scan;

/**
 Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.


 ---------------------------------------------------------------------------------------------------------------

 Just need a counter on top of previous...oh also need to clean up...lol

 */
public class Remove_Duplicates_Sorted_Array_II_80 {

    public static int removeDuplicates(int[] nums) {
        int dupeCount = 0;
        Integer previous = null;

        int goodPoint = 0;
        int current = 0;

        while (current < nums.length) {
            if ((previous == null) || (previous.intValue() != nums[current])) {
                // new number
                dupeCount = 0;
                previous = nums[current];

                swap(nums, goodPoint, current);
                goodPoint++;
                current++;
            }
            else {
                // dupe
                if (dupeCount >= 1) {
                    current++;
                    continue;
                }
                else {
                    dupeCount++;

                    swap(nums, goodPoint, current);
                    goodPoint++;
                    current++;
                }
            }
        }

        return goodPoint;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

}
