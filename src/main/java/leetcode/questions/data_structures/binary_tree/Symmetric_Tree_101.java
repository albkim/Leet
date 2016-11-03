package leetcode.questions.data_structures.binary_tree;

import leetcode.models.TreeNode;

/**

 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
     1
    / \
   2   2
  / \ / \
 3  4 4  3


 But the following [1,2,2,null,3,null,3] is not:

     1
    / \
   2   2
   \   \
    3    3


 Note:
 Bonus points if you could solve it both recursively and iteratively.

 --------------------------------------------------------------------------------------------------------------

 Seems like I can do level order traversal and see if each level is a palindrome

 Should use something like an array/list so that I can distinguish correct left/right

 Looks like we can do this much better by passing the tree twice and let it recursively compare different children

 */
public class Symmetric_Tree_101 {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetricRecursive(root, root);
    }

    private static boolean isSymmetricRecursive(TreeNode left, TreeNode right) {
        if ((left == null) && (right == null)) {
            return true;
        }

        if ((left == null) || (right == null)) {
            return false;
        }

        return left.val == right.val && isSymmetricRecursive(left.left, right.right) && isSymmetricRecursive(left.right, right.left);
    }

    public static boolean isSymmetricLevel(TreeNode root) {
        if (root == null) {
            return true;
        }

        TreeNode[] current = new TreeNode[] {root};

        int count = 1;
        while(count > 0) {
            // perform symmetric check
            int start = 0;
            int end = current.length - 1;
            while (start < end) {
                if ((current[start] != null) && (current[end] != null)) {
                    if (current[start].val != current[end].val) {
                        return false;
                    }
                }
                else if ((current[start] != null) && (current[end] == null)) {
                    return false;
                }
                else if ((current[start] == null) && (current[end] != null)) {
                    return false;
                }
                start++;
                end--;
            }

            count = 0;
            TreeNode[] next = new TreeNode[current.length * 2];
            for (int index = 0; index < current.length; index++) {
                TreeNode node = current[index];
                if (node == null) {
                    continue;
                }
                if (node.left != null) {
                    next[index * 2] = node.left;
                    count++;
                }
                if (node.right != null) {
                    next[index * 2 + 1] = node.right;
                    count++;
                }
            }

            current = next;
        }

        return true;
    }

}
