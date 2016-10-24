package leetcode.questions.test.data_structures.binary_tree;

import leetcode.questions.data_structures.binary_tree.Binary_Tree_Zigzag_Level_Order_Traversal_103;
import leetcode.models.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/2/2016.
 */
public class Binary_Tree_Zigzag_Level_Order_Traversal_103_Test {

    @Test
    public void testSimple() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = Binary_Tree_Zigzag_Level_Order_Traversal_103.zigzagLevelOrder(root);

        assertEquals(3, result.size());
        assertEquals(3, result.get(0).get(0).intValue());
        assertEquals(20, result.get(1).get(0).intValue());
        assertEquals(9, result.get(1).get(1).intValue());
        assertEquals(15, result.get(2).get(0).intValue());
        assertEquals(7, result.get(2).get(1).intValue());
    }

}
