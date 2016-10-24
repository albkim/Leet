package leetcode.questions.back_tracking;

import leetcode.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 For example:
 Given the below binary tree and sum = 22,
       5
      / \
     4   8
    /   / \
   11  13  4
  /  \    / \
 7    2  5   1


 return

 [
 [5,4,11,2],
 [5,8,4,5]
 ]


 ----------------------------------------------------------------------------------------------

 Same as path sum, just need to use the array and track the results

 */
public class Path_Sum_II_113 {

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        backtrack(root, sum, result, new ArrayList<>(), 0);

        return result;
    }

    private static void backtrack(TreeNode root, int sum, List<List<Integer>> result, List<Integer> current, int currentSum) {
        // leaf check
        if ((root.left == null) && (root.right == null)) {
            // current sum check
            if (currentSum + root.val == sum) {
                // make a copy
                List<Integer> good = new ArrayList<>(current);
                good.add(root.val);
                result.add(good);
            }
            return;
        }

        current.add(root.val);

        if (root.left != null) {
            backtrack(root.left, sum, result, current, currentSum + root.val);
        }

        if (root.right != null) {
            backtrack(root.right, sum, result, current, currentSum + root.val);
        }

        current.remove(current.size() - 1);
    }
}
