package leetcode.questions.data_structures.binary_tree;

import leetcode.models.TreeNode;

/**
 Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given
     1
    / \
   2   5
  / \   \
 3   4   6


 The flattened tree should look like:
 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6

 ----------------------------------------------------------------------------------------

 Isn't this just preorder traversal as we add to the linked list. Do do this to the same tree,
 hold a temp ref to the right node, pass current to the recursion for left, pass returned ref to right recursion

 */
public class Flatten_Binary_Tree_Linked_List_114 {

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root, null);
    }

    private static TreeNode flatten(TreeNode root, TreeNode newHead) {
        if (root == null) {
            return newHead;
        }

        TreeNode rightNode = root.right;

        // fix current node
        if (newHead != null) {
            newHead.right = root;
        }

        // recurse to left
        TreeNode newTail = flatten(root.left, root);

        // fix left
        root.left = null;

        return flatten(rightNode, newTail);
    }

}
