package leetcode.questions.test.data_structures.linked_list;

import leetcode.models.ListNode;
import leetcode.questions.data_structures.linked_list.Odd_Even_Linked_List_328;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/22/2016.
 */
public class Odd_Even_Linked_List_328_Test {

    @Test
    public void testSimple() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = Odd_Even_Linked_List_328.oddEvenList(head);

        assertEquals(1, result.val);
        assertEquals(3, result.next.val);
        assertEquals(5, result.next.next.val);
        assertEquals(2, result.next.next.next.val);
        assertEquals(4, result.next.next.next.next.val);

        assertNull(result.next.next.next.next.next);
    }

}
