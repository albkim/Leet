package leetcode.questions.data_structures.binary_tree;

import leetcode.models.TreeNode;

import java.util.*;

/**
 Given a binary tree, return the zigzag level order traversal of its nodes' values.
 (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
  /  \
 15   7


 return its zigzag level order traversal as:

 [
 [3],
 [20,9],
 [15,7]
 ]


 -----------------------------------------------------------------------------------------

 Same as level order, except we use stack instead of queue
 Also make sure left/right lookup is zigzagged

 */
public class Binary_Tree_Zigzag_Level_Order_Traversal_103 {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> current = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        current.push(root);

        boolean leftScan = true;
        List<Integer> level = new ArrayList<>();
        while(!current.isEmpty()) {
            TreeNode node = current.pop();
            if (leftScan) {
                if (node.left != null) {
                    next.push(node.left);
                }
                if (node.right != null) {
                    next.push(node.right);
                }
            }
            else {
                if (node.right != null) {
                    next.push(node.right);
                }
                if (node.left != null) {
                    next.push(node.left);
                }
            }
            level.add(node.val);

            if (current.isEmpty()) {
                current = next;
                result.add(level);
                level = new ArrayList<>();
                next = new Stack<>();
                leftScan = !leftScan;
            }
        }

        return result;
    }

}
