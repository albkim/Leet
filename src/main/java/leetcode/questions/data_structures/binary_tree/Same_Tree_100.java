package leetcode.questions.data_structures.binary_tree;

import leetcode.models.TreeNode;

/**
 Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.


 -----------------------------------------------------------------------------------------------------------

 Two pointer comparison

 */
public class Same_Tree_100 {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null) && (q == null)) {
            return true;
        }
        else if ((p == null) || (q == null)) {
            return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
