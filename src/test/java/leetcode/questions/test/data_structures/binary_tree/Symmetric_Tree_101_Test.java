package leetcode.questions.test.data_structures.binary_tree;

import leetcode.questions.data_structures.binary_tree.Symmetric_Tree_101;
import leetcode.models.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/2/2016.
 */
public class Symmetric_Tree_101_Test {

    @Test
    public void testSimple() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        assertTrue(Symmetric_Tree_101.isSymmetric(root));
    }

    @Test
    public void testSimpleFalse() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);

        assertFalse(Symmetric_Tree_101.isSymmetric(root));
    }

    @Test
    public void testSimpleFalse2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        assertFalse(Symmetric_Tree_101.isSymmetric(root));
    }

}
