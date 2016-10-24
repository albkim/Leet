package leetcode.questions.data_structures.binary_tree;

import leetcode.models.TreeNode;

/**
 Invert a binary tree.
         4
       /   \
      2     7
     / \   / \
    1   3 6   9

 to
         4
       /   \
      7     2
     / \   / \
    9   6 3   1

 -----------------------------------------------------------------------------

 Recursively swap left with right in post order traversal. I am guessing this requires creating a new tree.
 Will do that.

 */
public class Invert_Binary_Tree_226 {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        return invertTreeRecursive(root);
    }

    private static TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTreeRecursive(root.left);
        TreeNode right = invertTreeRecursive(root.right);

        TreeNode node = new TreeNode(root.val);
        node.left = right;
        node.right = left;
        return node;
    }

}
