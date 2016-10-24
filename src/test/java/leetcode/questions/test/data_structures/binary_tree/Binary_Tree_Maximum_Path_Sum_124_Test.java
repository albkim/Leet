package leetcode.questions.test.data_structures.binary_tree;

import leetcode.models.TreeNode;
import leetcode.questions.data_structures.binary_tree.Binary_Tree_Maximum_Path_Sum_124;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/3/2016.
 */
public class Binary_Tree_Maximum_Path_Sum_124_Test {

    @Test
    public void testEdge() {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(3);

        assertEquals(3, Binary_Tree_Maximum_Path_Sum_124.maxPathSum(root));
    }

    @Test
    public void testEdge1() {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        assertEquals(4, Binary_Tree_Maximum_Path_Sum_124.maxPathSum(root));
    }

    @Test
    public void testSimple() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        assertEquals(6, Binary_Tree_Maximum_Path_Sum_124.maxPathSum(root));
    }

    @Test
    public void testComplex() {
        /*
                        5
                       /\
                      4  8
                     /  / \
                    11 13  4
                   / \      \
                  7   2      1
         */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        assertEquals(48, Binary_Tree_Maximum_Path_Sum_124.maxPathSum(root));
    }

}
