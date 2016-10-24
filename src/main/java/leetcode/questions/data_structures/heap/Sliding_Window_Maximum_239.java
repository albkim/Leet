package leetcode.questions.data_structures.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 You can only see the k numbers in the window. Each time the sliding window moves right by one position.

 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7


 Therefore, return the max sliding window as [3,3,5,5,6,7].

 Note:
 You may assume k is always valid, ie: 1 ? k ? input array's size for non-empty array.

 Follow up:
 Could you solve it in linear time?

 ----------------------------------------------------------------------------------------------

 Seems like i can create a bounded heap and do some accounting

 */
public class Sliding_Window_Maximum_239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if ((nums == null) || (nums.length == 0)) {
            return new int[] {};
        }

        Queue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // populate with initial set
        for (int index = 0; index < Math.min(nums.length, k); index++) {
            max.add(nums[index]);
        }

        if (nums.length < k) {
            return new int[] {max.peek()};
        }

        int[] result = new int[nums.length - k + 1];
        for (int right = k - 1; right < nums.length; right++) {
            int left = right - k + 1;

            // add the max;
            result[left] = max.peek();

            // remove left
            max.remove(nums[left]);

            // add right
            if (right < nums.length - 1) {
                max.add(nums[right + 1]);
            }
        }

        return result;
    }

}
