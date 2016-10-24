package leetcode.questions.test.data_structures.binary_tree;

import leetcode.models.TreeNode;
import leetcode.questions.data_structures.binary_tree.Serialize_Deserialize_Binary_Tree_297;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Sang on 10/17/2016.
 */
public class Serialize_Deserialize_Binary_Tree_297_Test {

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

        TreeNode copy = Serialize_Deserialize_Binary_Tree_297.deserialize(Serialize_Deserialize_Binary_Tree_297.serialize(root));

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

    @Test
    public void testSimple1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(1);

        TreeNode copy = Serialize_Deserialize_Binary_Tree_297.deserialize(Serialize_Deserialize_Binary_Tree_297.serialize(root));

        assertNotNull(copy);

        assertEquals(5, copy.val);
        assertEquals(2, copy.left.val);
        assertEquals(3, copy.right.val);
        assertEquals(2, copy.right.left.val);
        assertEquals(4, copy.right.right.val);
        assertEquals(3, copy.right.left.left.val);
        assertEquals(1, copy.right.left.right.val);
    }

}
