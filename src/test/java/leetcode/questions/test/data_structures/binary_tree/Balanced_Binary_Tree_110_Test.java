package leetcode.questions.test.data_structures.binary_tree;

import leetcode.questions.data_structures.binary_tree.Balanced_Binary_Tree_110;
import leetcode.models.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/2/2016.
 */
public class Balanced_Binary_Tree_110_Test {

    @Test
    public void testEdge() {
        assertTrue(Balanced_Binary_Tree_110.isBalanced(null));
        assertTrue(Balanced_Binary_Tree_110.isBalanced(new TreeNode(1)));
    }

    @Test
    public void testSimple() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        assertTrue(Balanced_Binary_Tree_110.isBalanced(root));

        root.right = new TreeNode(3);

        assertTrue(Balanced_Binary_Tree_110.isBalanced(root));
    }

}
