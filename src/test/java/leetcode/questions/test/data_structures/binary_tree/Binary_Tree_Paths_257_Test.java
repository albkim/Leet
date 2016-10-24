package leetcode.questions.test.data_structures.binary_tree;

import leetcode.models.TreeNode;
import leetcode.questions.data_structures.binary_tree.Binary_Tree_Paths_257;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/15/2016.
 */
public class Binary_Tree_Paths_257_Test {

    @Test
    public void testSimple() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        List<String> result = Binary_Tree_Paths_257.binaryTreePaths(root);

        assertEquals(2, result.size());
        assertEquals("1->2->5", result.get(0));
        assertEquals("1->3", result.get(1));
    }

}
