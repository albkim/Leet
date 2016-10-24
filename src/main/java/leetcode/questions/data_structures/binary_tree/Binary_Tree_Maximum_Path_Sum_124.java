package leetcode.questions.data_structures.binary_tree;

import leetcode.models.TreeNode;

/**
 Given a binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node to any node
 in the tree along the parent-child connections. The path does not need to go through the root.

 For example:
 Given the below binary tree,
   1
  / \
 2   3

 Return 6.

-----------------------------------------------------------------------------------------------------------------

 We can do post order and update max, The possible path is left + current + right or just one/two of them if neither
 contributes. Then return the correct subtree sum to parent so we can consider that.


 */
public class Binary_Tree_Maximum_Path_Sum_124 {

    private static int maxSum;

    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        maxSum = Integer.MIN_VALUE;

        recurse(root);

        return maxSum;
    }

    private static int recurse(TreeNode root) {
        maxSum = Math.max(maxSum, root.val);

        // left, root, right, left + root, right + root, left + root + right
        int localMax = root.val;
        int localSum = root.val;
        if (root.left != null) {
            int leftSum = recurse(root.left);
            localMax = Math.max(localMax, leftSum + root.val);
            localSum += leftSum;
        }
        if (root.right != null) {
            int rightSum = recurse(root.right);
            localMax = Math.max(localMax, rightSum + root.val);
            localSum += rightSum;
        }

        maxSum = Math.max(maxSum, localMax);

        if ((root.left != null) && (root.right != null)) {
            maxSum = Math.max(maxSum, localSum);
        }

        return localMax;
    }

}
