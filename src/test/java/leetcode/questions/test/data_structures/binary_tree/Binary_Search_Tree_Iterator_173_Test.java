package leetcode.questions.test.data_structures.binary_tree;

import leetcode.models.TreeNode;
import leetcode.questions.data_structures.binary_tree.Binary_Search_Tree_Iterator_173;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/10/2016.
 */
public class Binary_Search_Tree_Iterator_173_Test {

    @Test
    public void testEdge() {
        Binary_Search_Tree_Iterator_173 iterator = new Binary_Search_Tree_Iterator_173(null);
    }

    @Test
    public void testSimple() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        Binary_Search_Tree_Iterator_173 iterator = new Binary_Search_Tree_Iterator_173(root);

        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertFalse(iterator.hasNext());
    }

}
