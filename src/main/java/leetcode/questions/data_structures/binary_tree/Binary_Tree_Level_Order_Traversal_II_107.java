package leetcode.questions.data_structures.binary_tree;

import leetcode.models.TreeNode;

import java.util.*;

/**
 Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
  /  \
 15   7

 return its bottom-up level order traversal as:

 [
 [15,7],
 [9,20],
 [3]
 ]


 ----------------------------------------------------------------------------------------------

 Not sure how this is different from level traversal. Seems like just insert the result to 0

 */
public class Binary_Tree_Level_Order_Traversal_II_107 {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> current = new ArrayDeque<>(Collections.singletonList(root));
        Queue<TreeNode> next = new ArrayDeque<>();

        List<Integer> level = new ArrayList<>();
        while (!current.isEmpty()) {
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
                result.add(0, level);
                level = new ArrayList<>();
                next = new ArrayDeque<>();
            }
        }

        return result;
    }

}
