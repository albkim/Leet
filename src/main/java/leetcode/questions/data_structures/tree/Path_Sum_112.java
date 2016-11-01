package leetcode.questions.data_structures.tree;

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

 Should be more like pre order dfs

 */
public class Path_Sum_112 {

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        return dfs(root, sum);
    }

    private static boolean dfs(TreeNode root, int sum) {
        sum -= root.val;
        if ((root.left == null) && (root.right == null)) {
            return sum == 0;
        }

        if ((root.left != null) && (dfs(root.left, sum))) {
            return true;
        }
        if ((root.right != null) && (dfs(root.right, sum))) {
            return true;
        }
        return false;
    }

}


