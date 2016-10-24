package leetcode.test.questions.linked_list;

import leetcode.models.ListNode;
import leetcode.questions.data_structures.linked_list.Reverse_Linked_List_II_92;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by albertk on 9/28/16.
 */
public class Reverse_Linked_List_II_92_Test {

    @Test
    public void testEdge() {
        assertNull(Reverse_Linked_List_II_92.reverseBetween(null, 0, 0));
    }

    @Test
    public void testEdge2() {
        ListNode head = new ListNode(1);
        assertEquals(head, Reverse_Linked_List_II_92.reverseBetween(head, 1, 1));
    }

    @Test
    public void testSimple() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = Reverse_Linked_List_II_92.reverseBetween(head, 2, 3);
        assertEquals(1, result.val);
        assertEquals(3, result.next.val);
        assertEquals(2, result.next.next.val);
        assertEquals(4, result.next.next.next.val);
        assertEquals(5, result.next.next.next.next.val);
    }

}
