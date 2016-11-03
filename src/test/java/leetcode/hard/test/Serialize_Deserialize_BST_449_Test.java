package leetcode.hard.test;

import leetcode.models.TreeNode;
import leetcode.hard.Serialize_Deserialize_BST_449;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/17/2016.
 */
public class Serialize_Deserialize_BST_449_Test {

    @Test
    public void testSimple() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode copy = Serialize_Deserialize_BST_449.deserialize(Serialize_Deserialize_BST_449.serialize(root));

        assertNotNull(copy);

        assertEquals(5, copy.val);
        assertEquals(3, copy.left.val);
        assertEquals(2, copy.left.left.val);
        assertEquals(1, copy.left.left.left.val);
        assertEquals(4, copy.left.right.val);
        assertEquals(8, copy.right.val);
        assertEquals(6, copy.right.left.val);
        assertEquals(7, copy.right.left.right.val);
        assertEquals(9, copy.right.right.val);
    }

}
