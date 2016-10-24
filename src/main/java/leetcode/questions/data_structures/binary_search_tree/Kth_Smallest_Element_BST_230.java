package leetcode.questions.data_structures.binary_search_tree;

import leetcode.models.TreeNode;

import java.util.Stack;

/**
 Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ? k ? BST's total elements.

 Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 How would you optimize the kthSmallest routine?

 ------------------------------------------------------------------------------------------------------

 Doing inorder traversal as I keep a count can find kth

 */
public class Kth_Smallest_Element_BST_230 {

    public static int kthSmallest(TreeNode root, int k) {
        // doing iterative traversal makes this easy
        if (root == null) {
            return -1;
        }

        int count = 0;
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();

        while((!stack.empty()) || (current != null)) {
            if (current != null) {
                stack.add(current);
                current = current.left;
            }
            else {
                current = stack.pop();

                count++;

                if (count == k) {
                    return current.val;
                }

                current = current.right;
            }
        }

        return -1;
    }

}
