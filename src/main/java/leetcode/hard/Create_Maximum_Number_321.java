package leetcode.hard;

import java.util.Stack;

/**
 Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length
 k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved.
 Return an array of the k digits. You should try to optimize your time and space complexity.

 Example 1:
 nums1 = [3, 4, 6, 5]
 nums2 = [9, 1, 2, 5, 8, 3]
 k = 5
 return [9, 8, 6, 5, 3]

 Example 2:
 nums1 = [6, 7]
 nums2 = [6, 0, 4]
 k = 5
 return [6, 7, 6, 0, 4]

 Example 3:
 nums1 = [3, 9]
 nums2 = [8, 9]
 k = 3
 return [9, 8, 9]

 -------------------------------------------------------------------------------------------------------

 Seems like the solution is to dp all possible maximum number from each array of various length. And then Further
 Merge sort them to get a length of k.

 Example 1. The trick is to reuse the result from the previous. We can start from the longest
 num1       4               3           2           1
        3,4,6,5         4,6,5           6,5         6
 num2       6               5           4           3           2           1
        9,1,2,5,8,3     9,2,5,8,3      9,5,8,3     9,8,3       9,8          9

 The merge then would be
 comparing the following
    num1(4) + num2(1)       num1(3) + num2(2)      num1(2) + num2(3)        num1(1)+ num2(4)        num2(5)
    9,3,4,6,5               9,8,4,6,5               9,8,6,5,3                   9,6,5,8,3           9,2,5,8,3

 Not sure if I can do this at an interview...lol
 */
public class Create_Maximum_Number_321 {

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int maxLength1 = Math.min(k, nums1.length);
        int[][] dpNum1 = new int[maxLength1 + 1][];
        dpNum1[0] = new int[0];
        for (int length = maxLength1; length > 0; length--) {
            dpNum1[length] = findMax((length == maxLength1) ? nums1 : dpNum1[length + 1], length);
        }

        int maxLength2 = Math.min(k, nums2.length);
        int[][] dpNum2 = new int[maxLength2 + 1][];
        dpNum2[0] = new int[0];
        for (int length = maxLength2; length > 0; length--) {
            dpNum2[length] = findMax((length == maxLength2) ? nums2 : dpNum2[length + 1], length);
        }

        int max[] = null;
        int lengthLeft = (maxLength1 > maxLength2) ? maxLength1 : maxLength2;
        int[][] left = (maxLength1 > maxLength2) ? dpNum1 : dpNum2;
        int[][] right = (maxLength1 > maxLength2) ? dpNum2 : dpNum1;

        for (int length1 = 1; length1 <= lengthLeft; length1++) {
            int length2 = k - length1;
            if (length2 > right.length - 1) {
                continue;
            }
            int[] candidate = merge(left[length1], right[length2]);
            if (max == null) {
                max = candidate;
            }
            else {
                int comparison = compare(max, candidate);
                if (comparison > 0) {
                    max = candidate;
                }
            }
        }

        return max;
    }

    private static int compare(int[] o1, int[] o2) {
        for (int index = 0; index < o1.length; index++) {
            if (o1[index] != o2[index]) {
                return o2[index] - o1[index];
            }
        }
        return 0;
    }

    private static int[] merge(int[] left, int[] right) {
        // merge sort in the descending order
        int[] result = new int[left.length + right.length];

        int resultIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while((leftIndex < left.length) || (rightIndex < right.length)) {
            int leftValue = (leftIndex < left.length) ? left[leftIndex] : Integer.MIN_VALUE;
            int rightValue = (rightIndex < right.length) ? right[rightIndex] : Integer.MIN_VALUE;

            if (leftValue == rightValue) {
                // compare the next and take the bigger one
                int nextLeft = leftValue;
                int nextRight = rightValue;
                int nextLeftIndex = leftIndex + 1;
                int nextRightIndex = rightIndex + 1;
                while (((nextLeftIndex < left.length) || (nextRightIndex < right.length)) && (nextLeft == nextRight)) {
                    nextLeft = (nextLeftIndex < left.length) ? left[nextLeftIndex] : Integer.MIN_VALUE;
                    nextRight = (nextRightIndex < right.length) ? right[nextRightIndex] : Integer.MIN_VALUE;
                    nextLeftIndex++;
                    nextRightIndex++;
                }
                if (nextLeft > nextRight) {
                    rightValue--;
                } else {
                    leftValue--;
                }
            }

            if (leftValue > rightValue) {
                result[resultIndex] = leftValue;
                leftIndex++;
            } else {
                result[resultIndex] = rightValue;
                rightIndex++;
            }
            resultIndex++;
        }
        return result;
    }

    private static int[] findMax(int[] nums, int length) {
        // use the stack trick to find the max
        Stack<Integer> stack = new Stack<>();
        for (int index = 0; index < nums.length; index++) {
            // look at stack, if there is a number less than me, and there are enough numbers behind me and in the stack to
            // make up the number of length, then pop it
            while(!stack.empty()) {
                int lengthStack = stack.size() - 1;
                int behindMeIncludingMe = nums.length - index;
                if ((stack.peek() < nums[index]) && (lengthStack + behindMeIncludingMe >= length)) {
                    stack.pop();
                }
                else {
                    break;
                }
            }
            if (stack.size() < length) {
                stack.add(nums[index]);
            }
        }

        int[] result = new int[length];
        for (int index = length - 1; index >= 0; index--) {
            result[index] = stack.pop();
        }
        return result;
    }

}
