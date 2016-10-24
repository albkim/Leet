package leetcode.questions.pointer_scan;

/**
 Given an array of integers that is already sorted in ascending order, find two numbers
 such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target,
 where index1 must be less than index2. Please note that your returned answers
 (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2

 -----------------------------------------------------------------------------------------------

 This is two sum with two pointer method. Not sure why index is not zero based...

 */
public class Two_Sum_II_Input_Array_Is_Sorted_167 {

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 };
            }
            else if (sum < target) {
                left++;
            }
            else {
                right--;
            }
        }

        return new int[]{};
    }

}
