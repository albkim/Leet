package leetcode.questions.back_tracking;

import leetcode.models.TreeNode;

/**
 *
 Given a binary tree and a sum, determine if the tree has a root-to-leaf path such
 that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
       5
      / \
     4   8
    /   / \
   11  13  4
  /  \      \
 7    2      1


 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 --------------------------------------------------------------------------------------------------

 Simple backtracking as we do preorder traversal

 */
public class Path_Sum_112 {

    private static class PathSumResult {
        public boolean found;
        public int current;
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        PathSumResult result = new PathSumResult();

        backtrack(root, sum, result);

        return result.found;
    }

    private static void backtrack(TreeNode root, int sum, PathSumResult result) {
        // leaf check
        if ((root.left == null) && (root.right == null)) {
            result.found = ((result.current + root.val) == sum);
            return;
        }

        result.current += root.val;

        if (root.left != null) {
            backtrack(root.left, sum, result);
            if (result.found) {
                return;
            }
        }

        if (root.right != null) {
            backtrack(root.right, sum, result);
            if (result.found) {
                return;
            }
        }

        result.current -= root.val;
    }

}


