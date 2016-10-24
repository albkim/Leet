package leetcode.questions.test.data_structures.linked_list;

import leetcode.models.ListNode;
import leetcode.questions.data_structures.linked_list.Intersection_Two_Linked_Lists_160;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/9/2016.
 */
public class Intersection_Two_Linked_Lists_160_Test {

    @Test
    public void testSimple() {
        ListNode cycleHead = new ListNode(31);
        cycleHead.next = new ListNode(32);
        cycleHead.next.next = new ListNode(33);

        ListNode headA = new ListNode(11);
        headA.next = new ListNode(12);
        headA.next.next = cycleHead;

        ListNode headB = new ListNode(21);
        headB.next = new ListNode(22);
        headB.next.next = new ListNode(23);
        headB.next.next.next = cycleHead;

        ListNode result = Intersection_Two_Linked_Lists_160.getIntersectionNode(headA, headB);

        assertEquals(31, result.val);
        assertNull(cycleHead.next.next.next);
    }

    @Test
    public void testNoIntersection() {
        ListNode headA = new ListNode(11);
        headA.next = new ListNode(12);

        ListNode headB = new ListNode(21);
        headB.next = new ListNode(22);
        headB.next.next = new ListNode(23);

        ListNode result = Intersection_Two_Linked_Lists_160.getIntersectionNode(headA, headB);

        assertNull(result);
    }

}
