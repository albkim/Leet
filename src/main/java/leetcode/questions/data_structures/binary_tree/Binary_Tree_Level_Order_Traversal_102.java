package leetcode.questions.data_structures.binary_tree;

import leetcode.models.TreeNode;

import java.util.*;

/**
 Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree [3,9,20,null,null,15,7],

   3
  / \
  9  20
  /  \
 15   7

 return its level order traversal as:

 [
 [3],
 [9,20],
 [15,7]
 ]

------------------------------------------------------------------------------------

 Even simple level order with a list in the result

 */
public class Binary_Tree_Level_Order_Traversal_102 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> current = new ArrayDeque<>(Collections.singletonList(root));
        Queue<TreeNode> next = new ArrayDeque<>();

        List<Integer> level = new ArrayList<>();
        while(!current.isEmpty()) {
            TreeNode node = current.poll();
            if (node.left != null) {
                next.add(node.left);
            }
            if (node.right != null) {
                next.add(node.right);
            }
            level.add(node.val);

            if (current.isEmpty()) {
                current = next;
                result.add(level);
                level = new ArrayList<>();
                next = new ArrayDeque<>();
            }
        }

        return result;
    }

}
