package leetcode.questions.data_structures.binary_tree;

import leetcode.models.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 Given a binary tree, return the postorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},

 1
  \
   2
  /
 3

 return [3,2,1].

 Note: Recursive solution is trivial, could you do it iteratively?

 ------------------------------------------------------------------------------------------

 Seems like similar to in order except that I need to push the current back into stack before iterating to right

 */
public class Binary_Tree_Postorder_Traversal_145 {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while((!stack.empty()) || (current != null)) {
            if (current != null) {
                // if there is right, put it first
                if (current.right != null) {
                    stack.add(current.right);
                }
                stack.add(current);

                // go left
                current = current.left;
            }
            else {
                current = stack.pop();

                // do a check whether there is a unvisited right (previous entry in the stack)
                if ((current.right != null) && (!stack.empty()) && (current.right == stack.peek())) {
                    stack.pop();
                    stack.push(current);
                    current = current.right;
                }
                else {
                    result.add(current.val);
                    current = null;
                }
            }
        }

        return result;
    }

}
