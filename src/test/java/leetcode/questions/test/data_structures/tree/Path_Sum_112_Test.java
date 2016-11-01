package leetcode.questions.test.data_structures.tree;

import leetcode.questions.data_structures.tree.Path_Sum_112;
import leetcode.models.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/2/2016.
 */
public class Path_Sum_112_Test {

    @Test
    public void testEdge() {
        assertFalse(Path_Sum_112.hasPathSum(null, 0));
        assertFalse(Path_Sum_112.hasPathSum(null, 1));
    }

    @Test
    public void testEdge1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        assertFalse(Path_Sum_112.hasPathSum(root, 1));
    }

    @Test
    public void testSimple() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        assertTrue(Path_Sum_112.hasPathSum(root, 22));
    }

}
