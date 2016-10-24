package leetcode.questions.test.data_structures.binary_tree;

import leetcode.questions.data_structures.binary_tree.Binary_Tree_Inorder_Traversal_94;
import leetcode.models.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by Sang on 9/28/2016.
 */
public class Binary_Tree_Inorder_Traversal_94_Test {

    @Test
    public void testSimple() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = Binary_Tree_Inorder_Traversal_94.inorderTraversal(root);

        assertEquals(3, result.size());
        assertEquals(1, result.get(0).intValue());
        assertEquals(3, result.get(1).intValue());
        assertEquals(2, result.get(2).intValue());
    }

}
