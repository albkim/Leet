package leetcode.questions.test.data_structures.binary_tree;

import leetcode.models.TreeNode;
import leetcode.questions.data_structures.binary_tree.Invert_Binary_Tree_226;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/14/2016.
 */
public class Invert_Binary_Tree_226_Test {

    @Test
    public void testSimple() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        root = Invert_Binary_Tree_226.invertTree(root);

        assertEquals(4, root.val);
        assertEquals(7, root.left.val);
        assertEquals(9, root.left.left.val);
        assertEquals(6, root.left.right.val);
        assertEquals(2, root.right.val);
        assertEquals(3, root.right.left.val);
        assertEquals(1, root.right.right.val);
    }

}
