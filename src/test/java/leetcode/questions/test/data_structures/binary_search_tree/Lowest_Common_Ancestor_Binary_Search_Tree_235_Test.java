package leetcode.questions.test.data_structures.binary_search_tree;

import leetcode.models.TreeNode;
import leetcode.questions.data_structures.binary_search_tree.Lowest_Common_Ancestor_Binary_Search_Tree_235;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/15/2016.
 */
public class Lowest_Common_Ancestor_Binary_Search_Tree_235_Test {

    @Test
    public void testSimple() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        assertEquals(6, Lowest_Common_Ancestor_Binary_Search_Tree_235.lowestCommonAncestor(root, root.left, root.right).val);
        assertEquals(2, Lowest_Common_Ancestor_Binary_Search_Tree_235.lowestCommonAncestor(root, root.left, root.left.right).val);
    }

}
