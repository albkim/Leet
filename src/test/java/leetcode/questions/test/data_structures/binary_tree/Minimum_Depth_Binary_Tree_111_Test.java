package leetcode.questions.test.data_structures.binary_tree;

import leetcode.questions.data_structures.binary_tree.Minimum_Depth_Binary_Tree_111;
import leetcode.models.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/2/2016.
 */
public class Minimum_Depth_Binary_Tree_111_Test {

    @Test
    public void testEdge() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        assertEquals(2, Minimum_Depth_Binary_Tree_111.minDepth(root));
    }

}
