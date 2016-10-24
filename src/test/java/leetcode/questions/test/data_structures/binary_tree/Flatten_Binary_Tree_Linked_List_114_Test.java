package leetcode.questions.test.data_structures.binary_tree;

import leetcode.questions.data_structures.binary_tree.Flatten_Binary_Tree_Linked_List_114;
import leetcode.models.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/2/2016.
 */
public class Flatten_Binary_Tree_Linked_List_114_Test {

    @Test
    public void testEdge() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        Flatten_Binary_Tree_Linked_List_114.flatten(root);

        assertEquals(1, root.val);
        assertNull(root.left);
        assertEquals(2, root.right.val);
    }

    @Test
    public void testSimple() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        Flatten_Binary_Tree_Linked_List_114.flatten(root);

        assertEquals(1, root.val);
        assertEquals(2, root.right.val);
        assertEquals(3, root.right.right.val);
        assertEquals(4, root.right.right.right.val);
        assertEquals(5, root.right.right.right.right.val);
        assertEquals(6, root.right.right.right.right.right.val);
    }

}
