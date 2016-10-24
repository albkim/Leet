package leetcode.questions.data_structures.binary_tree;

import leetcode.models.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 Given a binary tree, return the preorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},

 1
  \
   2
  /
 3

 return [1,2,3].

 Note: Recursive solution is trivial, could you do it iteratively?

 ------------------------------------------------------------------------------------------------

 Should be similar to in order except when we process the current

 */
public class Binary_Tree_Preorder_Traversal_144 {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while ((!stack.empty()) || (current != null)) {
            if (current != null) {
                // do something
                result.add(current.val);

                stack.add(current);

                current = current.left;
            }
            else {
                current = stack.pop();

                current = current.right;
            }
        }

        return result;
    }

}
