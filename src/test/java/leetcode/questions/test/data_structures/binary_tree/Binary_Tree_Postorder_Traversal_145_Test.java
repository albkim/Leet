package leetcode.questions.test.data_structures.binary_tree;

import leetcode.models.TreeNode;
import leetcode.questions.data_structures.binary_tree.Binary_Tree_Postorder_Traversal_145;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/8/2016.
 */
public class Binary_Tree_Postorder_Traversal_145_Test {

    @Test
    public void testSimple() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = Binary_Tree_Postorder_Traversal_145.postorderTraversal(root);

        assertEquals(3, result.size());

        assertEquals(3, result.get(0).intValue());
        assertEquals(2, result.get(1).intValue());
        assertEquals(1, result.get(2).intValue());
    }

}
