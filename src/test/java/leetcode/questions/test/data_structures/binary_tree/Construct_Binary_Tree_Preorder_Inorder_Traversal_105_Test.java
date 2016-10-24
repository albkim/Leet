package leetcode.questions.test.data_structures.binary_tree;

import leetcode.questions.data_structures.binary_tree.Construct_Binary_Tree_Preorder_Inorder_Traversal_105;
import leetcode.models.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/2/2016.
 */
public class Construct_Binary_Tree_Preorder_Inorder_Traversal_105_Test {

    @Test
    public void testSimple() {
        int[] preOrder = new int[] { 3, 2, 1, 5, 4, 6};
        int[] inOrder = new int[] {1, 2, 3, 4, 5, 6};

        TreeNode root = Construct_Binary_Tree_Preorder_Inorder_Traversal_105.buildTree(preOrder, inOrder);

        assertEquals(3, root.val);
        assertEquals(2, root.left.val);
        assertEquals(1, root.left.left.val);
        assertEquals(5, root.right.val);
        assertEquals(4, root.right.left.val);
        assertEquals(6, root.right.right.val);
    }
}
