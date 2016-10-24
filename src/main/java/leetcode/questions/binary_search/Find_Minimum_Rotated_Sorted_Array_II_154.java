package leetcode.questions.binary_search;

/**

 Follow up for "Find Minimum in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 The array may contain duplicates.

 --------------------------------------------------------------------------------------------

 Consider something like this

 111211

 When picking 1 where is the rotation

 Worst is 1111111...might as well just scan for min...not sure if this is a good question

 */
public class Find_Minimum_Rotated_Sorted_Array_II_154 {

    public static int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
        }

        return min;
    }

}
