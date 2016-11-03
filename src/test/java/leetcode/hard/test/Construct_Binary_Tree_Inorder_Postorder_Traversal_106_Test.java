package leetcode.hard.test;

import leetcode.hard.Construct_Binary_Tree_Inorder_Postorder_Traversal_106;
import leetcode.models.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/2/2016.
 */
public class Construct_Binary_Tree_Inorder_Postorder_Traversal_106_Test {

    @Test
    public void testSimple() {
        int[] inOrder = new int[] {1, 2, 3, 4, 5, 6};
        int[] postOrder = new int[] { 1, 2, 4, 6, 5, 3};

        TreeNode root = Construct_Binary_Tree_Inorder_Postorder_Traversal_106.buildTree(inOrder, postOrder);

        assertEquals(3, root.val);
        assertEquals(2, root.left.val);
        assertEquals(1, root.left.left.val);
        assertEquals(5, root.right.val);
        assertEquals(4, root.right.left.val);
        assertEquals(6, root.right.right.val);
    }

}
