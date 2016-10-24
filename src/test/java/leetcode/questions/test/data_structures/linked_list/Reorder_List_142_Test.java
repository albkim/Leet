package leetcode.questions.data_structures.linked_list;

import leetcode.models.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/8/2016.
 */
public class Reorder_List_142_Test {

    @Test
    public void testEdge() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        Reorder_List_142.reorderList(head);

        assertEquals(1, head.val);
        assertEquals(3, head.next.val);
        assertEquals(2, head.next.next.val);

        assertNull(head.next.next.next);
    }

    @Test
    public void testSimple() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        Reorder_List_142.reorderList(head);

        assertEquals(1, head.val);
        assertEquals(4, head.next.val);
        assertEquals(2, head.next.next.val);
        assertEquals(3, head.next.next.next.val);

        assertNull(head.next.next.next.next);
    }

}
