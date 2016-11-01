package leetcode.questions.pointer_scan;

import java.util.*;

/**

 You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 Example 1: 
 Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

 Return: [1,2],[1,4],[1,6]

 The first 3 pairs are returned from the sequence:
 [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

 Example 2: 
 Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

 Return: [1,1],[1,1]

 The first 2 pairs are returned from the sequence:
 [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

 Example 3: 
 Given nums1 = [1,2], nums2 = [3],  k = 3

 Return: [1,3],[2,3]

 All possible pairs are returned from the sequence:
 [1,3],[2,3]

 -------------------------------------------------------------------------------------------------

  This has to be more complex...we need to have n pointers
  where each item of first element could be paired with different item of the second array and then finding the lowest
  of them

 m + nlogn

 */
public class Find_K_Pairs_With_Smallest_Sum_373 {

    private static class Tracker {
        public int firstIndex;
        public int secondIndex;

        public Tracker(int firstIndex, int secondIndex) {
            this.firstIndex = firstIndex;
            this.secondIndex = secondIndex;
        }
    }

    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int count = 0;

        List<int[]> result = new ArrayList<>();

        if ((nums1 == null) || (nums1.length < 1) || (nums2 == null) || (nums2.length < 1)) {
            // not good but this is the expected behavior
            return result;
        }

        Queue<Tracker> min = new PriorityQueue<>(new Comparator<Tracker>() {
            @Override
            public int compare(Tracker o1, Tracker o2) {
                int sum1 = nums1[o1.firstIndex] + nums2[o1.secondIndex];
                int sum2 = nums1[o2.firstIndex] + nums2[o2.secondIndex];

                if (sum1 == sum2) {
                    return 0;
                }
                return sum1 < sum2 ? -1 : 1;
            }
        });

        for (int index = 0; index < nums1.length; index++) {
            min.add(new Tracker(index, 0));
        }

        while ((count < k) && (min.size() > 0)) {
            Tracker nextMin = min.poll();
            result.add(new int[] { nums1[nextMin.firstIndex], nums2[nextMin.secondIndex] });
            if (nextMin.secondIndex < (nums2.length - 1)) {
                // increment and put it back
                nextMin.secondIndex++;
                min.offer(nextMin);
            }
            count++;
        }

        return result;
    }

}
