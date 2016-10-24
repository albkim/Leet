package leetcode.questions.test.data_structures.linked_list;

import leetcode.models.ListNode;
import leetcode.questions.data_structures.linked_list.Remove_Linked_List_Elements_203;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/11/2016.
 */
public class Remove_Linked_List_Elements_203_Test {

    @Test
    public void testHead() {
        ListNode head = new ListNode(1);

        assertNull(Remove_Linked_List_Elements_203.removeElements(head, 1));
    }

    @Test
    public void testSimple() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        ListNode copy = Remove_Linked_List_Elements_203.removeElements(head, 6);

        assertNotNull(copy);
        assertEquals(1, copy.val);
        assertEquals(2, copy.next.val);
        assertEquals(3, copy.next.next.val);
        assertEquals(4, copy.next.next.next.val);
        assertEquals(5, copy.next.next.next.next.val);
        assertNull(copy.next.next.next.next.next);
    }

}
