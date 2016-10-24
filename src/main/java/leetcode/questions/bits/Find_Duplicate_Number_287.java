package leetcode.questions.bits;

/**
 Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

 Note:

 1.You must not modify the array (assume the array is read only).
 2.You must use only constant, O(1) extra space.
 3.Your runtime complexity should be less than O(n2).
 4.There is only one duplicate number in the array, but it could be repeated more than once.

 ---------------------------------------------------------------------------------------------------------

 Less than O(n2) suggest O(nlogn) or O(n) complexity. Without space, I don't think it's possible to get
 O(n). So some sort of binary search?

 Since there are duplicates, if we were to count each half of the 1-n range, we should have a half which has more #
 than what it should be (1, 1, 1, 2, 3, 4, 5, 6), if we look mid < 3, it should be 2, but count is 4...so we know it's
 in that range. this is nlogn

 */
public class Find_Duplicate_Number_287 {

    public static int findDuplicate(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return -1;
        }

        int left = 1;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + ((right - left) >> 1);

            int count = 0;
            int countLow = 0;
            for (int num : nums) {
                if (num == mid) {
                    count++;
                }
                else if (num < mid) {
                    countLow++;
                }
            }

            if (count > 1) {
                return mid;
            }

            if (countLow >= mid) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return - 1;
    }

}
