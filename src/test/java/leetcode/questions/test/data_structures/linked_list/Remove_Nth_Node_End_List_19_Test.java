package leetcode.questions.test.data_structures.linked_list;

import leetcode.questions.data_structures.linked_list.Remove_Nth_Node_End_List_19;
import leetcode.models.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/5/2016.
 */
public class Remove_Nth_Node_End_List_19_Test {

    @Test
    public void testBoundary() {
        ListNode head = new ListNode(1);

        assertNull(Remove_Nth_Node_End_List_19.removeNthFromEnd(head, 1));
    }

    @Test
    public void testBoundary2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        assertEquals(2, Remove_Nth_Node_End_List_19.removeNthFromEnd(head, 2).val);
    }

    @Test
    public void testSimple() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = Remove_Nth_Node_End_List_19.removeNthFromEnd(head, 2);

        assertEquals(head, result);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(5, result.next.next.next.val);
    }

}
