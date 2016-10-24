package leetcode.questions.data_structures.binary_tree;

import leetcode.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

    1
  /   \
 2     3
 \
  5

 All root-to-leaf paths are:
 ["1->2->5", "1->3"]

 ----------------------------------------------------------------------------

 Seems like a simple pre order traversal with backtracking

 */
public class Binary_Tree_Paths_257 {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        backtrackPreOder(result, new ArrayList<>(), root);

        return result;
    }

    private static void backtrackPreOder(List<String> result, ArrayList<Integer> current, TreeNode root) {
        if ((root.left == null) && (root.right == null)) {
            StringBuilder path = new StringBuilder();
            for (int number : current) {
                path.append(number);
                path.append("->");
            }
            path.append(root.val);
            result.add(path.toString());
        }

        if (root.left != null) {
            current.add(root.val);
            backtrackPreOder(result, current, root.left);
            current.remove(current.size() - 1);
        }
        if (root.right != null) {
            current.add(root.val);
            backtrackPreOder(result, current, root.right);
            current.remove(current.size() - 1);
        }
    }

}
