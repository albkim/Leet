package leetcode.questions.sorting;

import java.util.HashSet;
import java.util.Set;

/**
 Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

 Try to solve it in linear time/space.

 Return 0 if the array contains less than 2 elements.

 You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

 -------------------------------------------------------------------------------------------------------------

 Since it only asks for constant space, we can use a bucket sort which is linear with gaps. Then it's matter of
 scanning the buckets and find the largest gap.

 The bucket size should be (max - min) / (n - 1) since the smallest gap has to be bigger than this (cross bucket)
    If there is no gap it's equal to max - min
    if there is one gap, surely it will have to cross bucket
 */
public class Maximum_Gap_164 {

    public static int maximumGap(int[] nums) {
        if ((nums == null) || (nums.length < 2)) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> lookup = new HashSet<>();
        for (int num : nums) {
            lookup.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max) {
            return 0;
        }

        int bucketSize = (int)Math.ceil((max - min) * 1d / (nums.length - 1));
        int[][] buckets = new int[nums.length][2];
        for (int num : nums) {
            int bucketIndex = (num - min) / bucketSize;
            if (buckets[bucketIndex][0] == 0) {
                buckets[bucketIndex] = new int[] {num, num};
            }
            else {
                buckets[bucketIndex][0] = Math.min(buckets[bucketIndex][0], num);
                buckets[bucketIndex][1] = Math.max(buckets[bucketIndex][1], num);
            }
        }

        int maxGap = Integer.MIN_VALUE;

        int[] previous = null;

        for (int[] bucket : buckets) {
            if (bucket[0] == 0) {
                continue;
            }

            if (previous == null) {
                previous = bucket;
                continue;
            }

            maxGap = Math.max(maxGap, bucket[0] - previous[1]);
            previous = bucket;
        }

        return maxGap;
    }

}
