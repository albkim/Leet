package leetcode.questions.data_structures.binary_search_tree;

import leetcode.models.TreeNode;

/**
 Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:
 •The left subtree of a node contains only nodes with keys less than the node's key.
 •The right subtree of a node contains only nodes with keys greater than the node's key.
 •Both the left and right subtrees must also be binary search trees.


 Example 1:

  2
 / \
 1   3

 Binary tree [2,1,3], return true.

 Example 2:

 1
 / \
 2   3

 Binary tree [1,2,3], return false.

 */
public class Validate_Binary_Search_Tree_98 {

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }

        return minValue < root.val && root.val < maxValue &&
                isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }

}
