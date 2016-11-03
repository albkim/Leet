package leetcode.hard;

import leetcode.models.TreeNode;

/**

 Given inorder and postorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.
 ------------------------------------------------------------------------------------------------

        3
    2           5
 1          4       6

 Inorder gives ordered list
 1, 2, 3, 4, 5, 6

 Postorder gives
 1, 2, 4, 6, 5, 3

 Since it's a binary tree not bst, postorder & inorder can be used to reconstruct it. Last postorder is the root.
 left of root in inorder is left and rest is right

 1 -2 is left
 3 is root
 4 - 5 is right

 */
public class Construct_Binary_Tree_Inorder_Postorder_Traversal_106 {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if ((inorder.length == 0) || (postorder.length == 0)) {
            return null;
        }

        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        TreeNode root = new TreeNode(postorder[postEnd]);

        int newInEnd = inStart;
        for(int index = inStart; index <= inEnd; index++) {
            if (inorder[index] == postorder[postEnd]) {
                newInEnd = index;
                break;
            }
        }

        int diff = newInEnd - inStart;
        if (diff > 0) {
            root.left = buildTree(inorder, inStart, newInEnd - 1, postorder, postStart, postStart + diff - 1);
        }
        if (postStart + (newInEnd - inStart) < postEnd) {
            root.right = buildTree(inorder, newInEnd + 1, inEnd, postorder, postStart + diff, postEnd - 1);
        }

        return root;
    }

}
