package leetcode.questions.recursion;

import leetcode.models.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sang on 9/29/2016.
 */
public class Unique_Binary_Search_Trees_II_95 {

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return backtrack(1, n);
    }

    private static List<TreeNode> backtrack(int start, int end) {
        if (end == start) {
            return Collections.singletonList(new TreeNode(start));
        }

        List<TreeNode> result = new ArrayList<>();
        for (int rootValue = start; rootValue <= end; rootValue++) {
            List<TreeNode> left = (rootValue - start == 0) ? null : backtrack(start, rootValue - 1);
            List<TreeNode> right = (end - rootValue == 0) ? null : backtrack(rootValue + 1, end);

            if ((left != null) && (right != null)) {
                for (TreeNode leftTree : left) {
                    for (TreeNode rightTree : right) {
                        TreeNode root = new TreeNode(rootValue);
                        root.left = leftTree;
                        root.right = rightTree;
                        result.add(root);
                    }
                }
            }
            else if (left != null) {
                for (TreeNode leftTree : left) {
                    TreeNode root = new TreeNode(rootValue);
                    root.left = leftTree;
                    result.add(root);
                }
            }
            else if (right != null) {
                for (TreeNode rightTree : right) {
                    TreeNode root = new TreeNode(rootValue);
                    root.right = rightTree;
                    result.add(root);
                }
            }
        }
        return result;
    }

}
