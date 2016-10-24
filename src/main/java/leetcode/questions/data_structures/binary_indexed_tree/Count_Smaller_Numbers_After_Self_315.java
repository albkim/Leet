package leetcode.questions.data_structures.binary_indexed_tree;

import java.util.ArrayList;
import java.util.List;

/**
 You are given an integer array nums and you have to return a new counts array.
 The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

 Example:
 Given nums = [5, 2, 6, 1]

 To the right of 5 there are 2 smaller elements (2 and 1).
 To the right of 2 there is only 1 smaller element (1).
 To the right of 6 there is 1 smaller element (1).
 To the right of 1 there is 0 smaller element.


 Return the array [2, 1, 1, 0].

 ----------------------------------------------------------------------------------------------------------

 If we are the bucket the numbers into count of number, we can create a binary indexed tree. Then it's just a matter of counting.

           4
        /    \
       2     6
     /  \   /
    1    3 5

           100
        /      \
      010     110
     /   \    /
    001  011 101

 Update is index + set bit (left to right)
 Sum is index & (flipped set bit) (right - left) -> index & (index - 1)

 Traverse right to left.
    when we see 1, we first sum S(0) which is 0 then we do update on U(1) which updates 1, 2, 4 to 1.
    when we see 6, we first sum S(5) which is 1 (5 -> 4) then we do update on U(6) which updates 5, 6 to 1.
    when we see 2, we first sum S(1) which is 1 then we do update on U(2) which updates 2, 4 to 2.
    when we see 5, we first sum S(4) which is 2 (4), then we do update on U(5) which updates 5,6 to 2

 need negative and equal element handling...
    offset index to positive numbers and update (n - 1)

 */
public class Count_Smaller_Numbers_After_Self_315 {

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if ((nums == null) || (nums.length == 0)) {
            return result;
        }

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] bit = new int[shiftedIndex(max) + 1];
        for (int index = nums.length - 1; index >= 0; index--) {
            result.add(0, sum(bit, shiftedIndex(nums[index]) - 1));
            update(bit, shiftedIndex(nums[index]));
        }

        return result;
    }

    private static int shiftedIndex(int number) {
        return number + 100000;
    }

    private static int sum(int[] bit, int index) {
        int sum = 0;
        while(index > 0) {
            sum += bit[index];

            index &= index - 1;
        }
        return sum;
    }

    private static void update(int[] bit, int index) {
        while(index < bit.length) {
            bit[index] += 1;

            // find set bit position
            int shift = 0;
            while(((index >> shift) & 1) != 1) {
                shift++;
            }

            index += 1 << shift;
        }
    }

}
