package leetcode.questions.data_structures.binary_tree;

import leetcode.models.TreeNode;

/**
 Given preorder and inorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.

 ------------------------------------------------------------------------------------------------

        3
    2           5
 1          4       6

 Inorder gives ordered list
 1, 2, 3, 4, 5, 6

 Preorder gives
 3, 2, 1, 5, 4, 6

 Since it's a binary tree not bst, inorder can serve to show what's left

 so once we scan in order to find the root of current preorder, we know how many we need to scan right on pre order

 3 is root
    1, 2 is on the left (from inorder)
    so 2, 1 is on the left

 2 is root
    1 is on the left (from inorder)
    so 1 is on the left

 1 is root

 5 is root
    4 is on the left (from in order

 4 is root

 6 is root

 */
public class Construct_Binary_Tree_Preorder_Inorder_Traversal_105 {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if ((preorder.length == 0) || (inorder.length == 0)) {
            return null;
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        TreeNode root = new TreeNode(preorder[preStart]);

        // find what's on the left
        int newInEnd = inStart;
        for (int index = inStart; index <= inEnd; index++) {
            if (inorder[index] == preorder[preStart]) {
                newInEnd = index;
                break;
            }
        }

        int diff = newInEnd - inStart;
        if (diff > 0) {
            root.left = buildTree(preorder, preStart + 1, preStart + diff, inorder, inStart, newInEnd - 1);
        }
        if (newInEnd < inEnd) {
            root.right = buildTree(preorder, preStart + diff + 1, preEnd, inorder, newInEnd + 1, inEnd);
        }

        return root;
    }

}
