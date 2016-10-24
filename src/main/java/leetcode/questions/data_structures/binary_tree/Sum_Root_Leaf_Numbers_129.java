package leetcode.questions.data_structures.binary_tree;

import leetcode.models.TreeNode;

/**
 Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,
   1
  / \
 2   3



 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.

 --------------------------------------------------------------------------------------------------------

 Just dfs

 */
public class Sum_Root_Leaf_Numbers_129 {

    private static int total;

    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        total = 0;

        dfs(root, 0);

        return total;
    }

    private static void dfs(TreeNode root, int number) {
        if ((root.left == null) && (root.right == null)) {
            // leaf node, add to total
            total += number * 10 + root.val;
            return;
        }

        int pathTotal = number * 10 + root.val;
        if (root.left != null) {
            dfs(root.left, pathTotal);
        }
        if (root.right != null) {
            dfs(root.right, pathTotal);
        }
    }

}
