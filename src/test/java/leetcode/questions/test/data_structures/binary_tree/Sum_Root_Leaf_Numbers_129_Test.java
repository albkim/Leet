package leetcode.questions.test.data_structures.binary_tree;

import leetcode.models.TreeNode;
import leetcode.questions.data_structures.binary_tree.Sum_Root_Leaf_Numbers_129;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/5/2016.
 */
public class Sum_Root_Leaf_Numbers_129_Test {

    @Test
    public void testSimple() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        assertEquals(25, Sum_Root_Leaf_Numbers_129.sumNumbers(root));
    }

}
