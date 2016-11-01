package leetcode.questions.data_structures.binary_search_tree;

import leetcode.models.TreeNode;

/**
 Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

 According to the definition of LCA on Wikipedia: �The lowest common ancestor is defined between
 two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a
 node to be a descendant of itself).�
             _______6______
            /              \
        ___2__          ___8__
      /      \        /      \
    0       _4       7       9
          /  \
         3   5


 For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of
 nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

 --------------------------------------------------------------------------------------------

 As we do post order traversal, we want to find the node where we satisfy this condition

    we find the values from other two sides or one side with the current node

 */
public class Lowest_Common_Ancestor_Binary_Search_Tree_235 {

    private static class Result {
        public TreeNode lca;
        public int found;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        Result result = postOrderTraversal(root, p, q);
        return result.lca;
    }

    private static Result postOrderTraversal(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return new Result();
        }

        int found = 0;
        Result leftResult = postOrderTraversal(root.left, p, q);
        if (leftResult.lca != null) {
            return leftResult;
        }
        found += leftResult.found;

        Result rightResult = postOrderTraversal(root.right, p, q);
        if (rightResult.lca != null) {
            return rightResult;
        }
        found += rightResult.found;

        if ((root.val == p.val) || (root.val == q.val)) {
            found++;
        }

        Result result = new Result();
        if (found == 2) {
            result.lca = root;
            return result;
        }

        result.found = found;

        return result;
    }

}
