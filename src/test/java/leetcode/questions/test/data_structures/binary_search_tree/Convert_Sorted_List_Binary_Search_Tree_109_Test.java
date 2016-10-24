package leetcode.questions.test.data_structures.binary_search_tree;

import leetcode.questions.data_structures.binary_search_tree.Convert_Sorted_List_Binary_Search_Tree_109;
import leetcode.models.ListNode;
import leetcode.models.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/2/2016.
 */
public class Convert_Sorted_List_Binary_Search_Tree_109_Test {

    @Test
    public void testSimple() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        TreeNode root = Convert_Sorted_List_Binary_Search_Tree_109.sortedListToBST(head);

        assertEquals(4, root.val);
        assertEquals(2, root.left.val);
        assertEquals(1, root.left.left.val);
        assertEquals(3, root.left.right.val);
        assertEquals(6, root.right.val);
        assertEquals(5, root.right.left.val);
        assertEquals(7, root.right.right.val);
    }

}
