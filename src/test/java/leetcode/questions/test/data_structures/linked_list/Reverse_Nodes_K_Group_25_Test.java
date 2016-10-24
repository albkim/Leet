package leetcode.questions.test.data_structures.linked_list;

import leetcode.questions.data_structures.linked_list.Reverse_Nodes_K_Group_25;
import leetcode.models.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/5/2016.
 */
public class Reverse_Nodes_K_Group_25_Test {

    @Test
    public void testSimple() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = Reverse_Nodes_K_Group_25.reverseKGroup(head, 2);

        assertEquals(2, result.val);
        assertEquals(1, result.next.val);
        assertEquals(4, result.next.next.val);
        assertEquals(3, result.next.next.next.val);
        assertEquals(5, result.next.next.next.next.val);
    }

    @Test
    public void testComplex() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = Reverse_Nodes_K_Group_25.reverseKGroup(head, 3);

        assertEquals(3, result.val);
        assertEquals(2, result.next.val);
        assertEquals(1, result.next.next.val);
        assertEquals(4, result.next.next.next.val);
        assertEquals(5, result.next.next.next.next.val);
    }

}
