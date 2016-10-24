package leetcode.questions.data_structures.binary_tree;

import leetcode.models.TreeNode;

/**
 Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree in which
 the depth of the two subtrees of every node never differ by more than 1.

 -----------------------------------------------------------------------------------------------------------

 Recursively compare depth as we go down and come back up

 */
public class Balanced_Binary_Tree_110 {

    private static class BalancedResult {
        public int depth;
        public boolean balanced;
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        BalancedResult result = isBalancedRecursive(root);
        return result.balanced;
    }

    private static BalancedResult isBalancedRecursive(TreeNode root) {
        if (root == null) {
            BalancedResult result = new BalancedResult();
            result.depth = 0;
            result.balanced = true;
            return result;
        }


        BalancedResult resultLeft = isBalancedRecursive(root.left);
        BalancedResult resultRight = isBalancedRecursive(root.right);

        BalancedResult result = new BalancedResult();

        result.depth = Math.max(resultLeft.depth, resultRight.depth) + 1;
        result.balanced = resultLeft.balanced
                        && resultRight.balanced
                        && Math.abs(resultLeft.depth - resultRight.depth) <= 1;

        return result;
    }

}
