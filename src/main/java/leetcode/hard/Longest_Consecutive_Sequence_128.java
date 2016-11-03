package leetcode.hard;

import java.util.*;

/**
 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.


 --------------------------------------------------------------------------------------------------------------

 The hint is to use union find. I wonder if I can do something like:

    Use a dictionary to track all the numbers I've seen and total counts of consecutive numbers. I just need to look
    at n-1 and n+1

    Union - Find - think of this as a graph, when we union, nodes are joined (by annotating it with a root). If
    two numbers have same root, they are joined. Find can use this info to see if two items are joined.

    Only downside is that if two subsets are joined, we need to update all roots

 */
public class Longest_Consecutive_Sequence_128 {

    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> rootLookup = new HashMap<>();
        Map<Integer, Set<Integer>> childLookup = new HashMap<>();

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            Integer rootLeft = null;
            Integer rootRight = null;
            if (rootLookup.containsKey(num - 1)) {
                rootLeft = rootLookup.get(num - 1);
            }
            if (rootLookup.containsKey(num + 1)) {
                rootRight = rootLookup.get(num + 1);
            }

            Integer root = null;
            Set<Integer> children = null;
            if ((rootLeft == null) && (rootRight == null)) {
                // new root
                root = num;
                children = new HashSet<>();
                childLookup.put(num, children);
            }
            else if ((rootLeft != null) && (rootRight != null) && (rootLeft != rootRight)) {
                // hey this connects subsets
                Set<Integer> oldChildren = null;
                if (childLookup.get(rootRight).size() < childLookup.get(rootLeft).size()) {
                    root = rootRight;
                    children = childLookup.get(rootRight);
                    oldChildren = childLookup.get(rootLeft);
                    childLookup.remove(rootLeft);
                }
                else {
                    root = rootLeft;
                    children = childLookup.get(rootLeft);
                    oldChildren = childLookup.get(rootRight);
                    childLookup.remove(rootRight);
                }

                for (int child : oldChildren) {
                    children.add(child);
                    rootLookup.put(child, root);
                }
            }
            else if (rootLeft != null) {
                root = rootLeft;
                children = childLookup.get(rootLeft);
            }
            else {
                root = rootRight;
                children = childLookup.get(rootRight);
            }

            rootLookup.put(num, root);
            children.add(num);

            max = Math.max(max, children.size());
        }

        return max;
    }

}
