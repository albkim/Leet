package leetcode.questions.test.data_structures.binary_search_tree;

import leetcode.questions.data_structures.binary_search_tree.Recover_Binary_Search_Tree_99;
import leetcode.models.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/1/2016.
 */
public class Recover_Binary_Search_Tree_99_Test {

    @Test
    public void testSameSubTree() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(2);

        Recover_Binary_Search_Tree_99.recoverTree(root);

        assertEquals(1, root.val);
        assertEquals(2, root.right.val);
        assertEquals(3, root.right.right.val);
    }

    @Test
    public void testSameSubTree2() {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(1);

        Recover_Binary_Search_Tree_99.recoverTree(root);

        assertEquals(1, root.val);
        assertEquals(2, root.right.val);
        assertEquals(3, root.right.right.val);
    }

    @Test
    public void testSidesSubTree() {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(1);
        root.left = new TreeNode(3);

        Recover_Binary_Search_Tree_99.recoverTree(root);

        assertEquals(2, root.val);
        assertEquals(1, root.left.val);
        assertEquals(3, root.right.val);
    }

}
