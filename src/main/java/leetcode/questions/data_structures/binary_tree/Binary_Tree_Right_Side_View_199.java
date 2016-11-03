package leetcode.questions.data_structures.binary_tree;

import leetcode.models.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 Given a binary tree, imagine yourself standing on the right side of it, return the values
 of the nodes you can see ordered from top to bottom.

 For example:
 Given the following binary tree,

    1            <---
  /   \
 2     3         <---
  \     \
   5     4       <---

 You should return [1, 3, 4].

 --------------------------------------------------------------------------------------------

 Not sure what this is after. Isn't it just traversing on the right, and if null then traverse left?

 LOL of course not, too easy. Consider this.

    1
  /  \
 2   3
  \
   4

 Try level traversal...and just take the last element

 The level traversal uses too much space...another solution is to do pre order traversal (right first) and try to add one
 that matches the level

 */
public class Binary_Tree_Right_Side_View_199 {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        rightSideViewRecurse(result, root, 0);

        return result;
    }

    private static void rightSideViewRecurse(List<Integer> result, TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (result.size() == level) {
            result.add(root.val);
        }

        // right side first
        rightSideViewRecurse(result, root.right, level + 1);
        rightSideViewRecurse(result, root.left, level + 1);
    }

    public static List<Integer> rightSideViewLevel(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> current = new ArrayDeque<>();
        Queue<TreeNode> next = new ArrayDeque<>();

        current.add(root);

        while(!current.isEmpty()) {
            TreeNode node = current.poll();

            if (node.left != null) {
                next.add(node.left);
            }
            if (node.right != null) {
                next.add(node.right);
            }

            if (current.isEmpty()) {
                result.add(node.val);
                current = next;
                next = new ArrayDeque<>();
            }
        }

        return result;
    }

}
