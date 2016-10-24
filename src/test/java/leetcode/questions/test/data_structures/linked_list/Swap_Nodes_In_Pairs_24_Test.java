package leetcode.questions.test.data_structures.linked_list;

import leetcode.questions.data_structures.linked_list.Swap_Nodes_In_Pairs_24;
import leetcode.models.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/5/2016.
 */
public class Swap_Nodes_In_Pairs_24_Test {

    @Test
    public void testEdge() {
        assertNull(Swap_Nodes_In_Pairs_24.swapPairs(null));

        ListNode head = new ListNode(1);
        ListNode result = Swap_Nodes_In_Pairs_24.swapPairs(head);
        assertEquals(1, result.val);
        assertNull(result.next);
    }

    @Test
    public void testEdge2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode result = Swap_Nodes_In_Pairs_24.swapPairs(head);
        assertEquals(2, result.val);
        assertEquals(1, result.next.val);
        assertEquals(3, result.next.next.val);
    }

    @Test
    public void testSimple() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        ListNode result = Swap_Nodes_In_Pairs_24.swapPairs(head);
        assertEquals(2, result.val);
        assertEquals(1, result.next.val);
    }

    @Test
    public void testComplex() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode result = Swap_Nodes_In_Pairs_24.swapPairs(head);
        assertEquals(2, result.val);
        assertEquals(1, result.next.val);
        assertEquals(4, result.next.next.val);
        assertEquals(3, result.next.next.next.val);
    }

}
