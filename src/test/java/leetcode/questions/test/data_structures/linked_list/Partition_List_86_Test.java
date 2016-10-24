package leetcode.questions.test.data_structures.linked_list;

import leetcode.questions.data_structures.linked_list.Partition_List_86;
import leetcode.models.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/24/2016.
 */
public class Partition_List_86_Test {

    @Test
    public void testSimple() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode result = Partition_List_86.partition(head, 3);

        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(2, result.next.next.val);
        assertEquals(4, result.next.next.next.val);
        assertEquals(3, result.next.next.next.next.val);
        assertEquals(5, result.next.next.next.next.next.val);
    }

    @Test
    public void testEdge() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);

        ListNode result = Partition_List_86.partition(head, 2);

        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
    }

}
