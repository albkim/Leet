package leetcode.questions.data_structures.binary_tree;

import leetcode.models.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree [1,null,2,3],

   1
    \
    2
   /
 3

 return [1,3,2].

 Note: Recursive solution is trivial, could you do it iteratively?


 ------------------------------------------------------------------------------------------------

 This can be done using stack


 */
public class Binary_Tree_Inorder_Traversal_94 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();

        // set current to root
        TreeNode current = root;

        // now evaluate all stack
        while((!stack.empty()) || (current != null)) {
            if (current != null) {
                // current pointer is being used to track where we are...need to always set this to null
                // to indicate we are done traversing. So first push current into stack and try left
                stack.push(current);

                // need to always traverse to the left most element
                current = current.left;
            }
            else {
                // we are done traversing to where ever we got to...now need to pop off from stack to start processing
                current = stack.pop();

                // now current is always the left most node which hasn't been processed
                result.add(current.val);

                current = current.right;
            }
        }

        return result;
    }

}
