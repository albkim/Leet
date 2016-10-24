package leetcode.questions.test.data_structures.binary_tree;

import leetcode.models.TreeNode;
import leetcode.questions.data_structures.binary_tree.Binary_Tree_Right_Side_View_199;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/11/2016.
 */
public class Binary_Tree_Right_Side_View_199_Test {

    @Test
    public void testEdge() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<Integer> result = Binary_Tree_Right_Side_View_199.rightSideView(root);

        assertNotNull(result);
        assertEquals(3, result.size());

        assertEquals(1, result.get(0).intValue());
        assertEquals(3, result.get(1).intValue());
        assertEquals(5, result.get(2).intValue());
    }

    @Test
    public void testSimple() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        List<Integer> result = Binary_Tree_Right_Side_View_199.rightSideView(root);

        assertNotNull(result);
        assertEquals(3, result.size());

        assertEquals(1, result.get(0).intValue());
        assertEquals(3, result.get(1).intValue());
        assertEquals(4, result.get(2).intValue());
    }

}
