package leetcode.questions.test.data_structures.binary_search_tree;

import leetcode.questions.data_structures.binary_search_tree.Convert_Sorted_Array_Binary_Search_Tree_108;
import leetcode.models.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/2/2016.
 */
public class Convert_Sorted_Array_Binary_Search_Tree_108_Test {

    @Test
    public void testSimple() {
        int[] sorted = new int[] {1, 2, 3, 4, 5, 6, 7};

        TreeNode root = Convert_Sorted_Array_Binary_Search_Tree_108.sortedArrayToBST(sorted);

        assertEquals(4, root.val);
        assertEquals(2, root.left.val);
        assertEquals(1, root.left.left.val);
        assertEquals(3, root.left.right.val);
        assertEquals(6, root.right.val);
        assertEquals(5, root.right.left.val);
        assertEquals(7, root.right.right.val);
    }

}
