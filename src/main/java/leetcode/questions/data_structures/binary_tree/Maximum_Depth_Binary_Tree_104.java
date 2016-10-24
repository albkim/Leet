package leetcode.questions.data_structures.binary_tree;

import leetcode.models.TreeNode;

/**
 Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 ------------------------------------------------------------------------------------------------------------

 Max of left & right length as one does post order

 */
public class Maximum_Depth_Binary_Tree_104 {

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depthLeft = maxDepth(root.left);
        int depthRight = maxDepth(root.right);

        return Math.max(depthLeft, depthRight) + 1;
    }

}
