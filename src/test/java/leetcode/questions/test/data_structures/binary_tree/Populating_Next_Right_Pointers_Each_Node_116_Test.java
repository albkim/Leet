package leetcode.questions.test.data_structures.binary_tree;

import leetcode.questions.data_structures.binary_tree.Populating_Next_Right_Pointers_Each_Node_116;
import leetcode.models.TreeLinkNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/2/2016.
 */
public class Populating_Next_Right_Pointers_Each_Node_116_Test {

    @Test
    public void testSimple() {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right = new TreeLinkNode(3);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);

        Populating_Next_Right_Pointers_Each_Node_116.connect(root);

        assertNull(root.next);
        assertEquals(root.right, root.left.next);
        assertNull(root.right.next);
        assertEquals(root.left.right, root.left.left.next);
        assertEquals(root.right.left, root.left.right.next);
        assertEquals(root.right.right, root.right.left.next);
        assertNull(root.right.right.next);
    }

}
