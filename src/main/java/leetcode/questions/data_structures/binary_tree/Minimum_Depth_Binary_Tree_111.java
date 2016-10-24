package leetcode.questions.data_structures.binary_tree;

import leetcode.models.TreeNode;

/**
 Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

 ------------------------------------------------------------------------------------------------------------------

 As we recurse down and come back up, take the min height of both sub tree

 Looks like we have to reach the leaf node, which is defined by a node with no children

 */
public class Minimum_Depth_Binary_Tree_111 {

    private static class MinResult {
        public int depth;
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        MinResult result = new MinResult();
        result.depth = Integer.MAX_VALUE;
        minDepth(root, result, 0);
        return result.depth;
    }

    private static void minDepth(TreeNode root, MinResult result, int depth) {
        if ((root.left == null) && (root.right == null)) {
            // this is a leaf, so update the result with this depth
            result.depth = Math.min(result.depth, depth + 1);
            return;
        }

        if (root.left != null) {
            minDepth(root.left, result, depth + 1);
        }

        if (root.right != null) {
            minDepth(root.right, result, depth + 1);
        }
    }
}
