package leetcode.questions.binary_search;

/**
 Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.


 ----------------------------------------------------------------------------------------

 think about a case like:
 1111111111111115 -> 11111511111111111

 we just cannot determine the rotation

 */
public class Search_Rotated_Sorted_Array_II_81 {

    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + ((right - left) >> 1);

            if (nums[mid] == target) {
                return true;
            }
            else {
                // try to determine if this is the worst case
                if ((nums[left] == nums[right]) && (nums[left] != target)) {
                    // hmm
                    left++;
                    right--;
                }
                else {
                    // 34567812 vs 78123456
                    boolean rightRotation = nums[left] <= nums[mid] && nums[mid] > nums[right];
                    if (rightRotation) {
                        if ((nums[left] <= target) && (target < nums[mid])) {
                            right = mid - 1;
                        }
                        else {
                            left = mid + 1;
                        }
                    }
                    else {
                        if ((nums[mid] < target) && (target <= nums[right])) {
                            left = mid + 1;
                        }
                        else {
                            right = mid - 1;
                        }
                    }
                }
            }
        }

        return false;
    }

}
