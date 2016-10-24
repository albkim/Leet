package leetcode.questions.test.data_structures.linked_list;

import leetcode.questions.data_structures.linked_list.Merge_k_Sorted_Lists_23;
import leetcode.models.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/5/2016.
 */
public class Merge_k_Sorted_Lists_23_Test {

    @Test
    public void testSimple() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);

        ListNode result = Merge_k_Sorted_Lists_23.mergeKLists(new ListNode[] {one, two, three});

        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
    }

    @Test
    public void testComplex() {
        ListNode one = new ListNode(1);
        one.next = new ListNode(5);
        ListNode two = new ListNode(2);
        two.next = new ListNode(4);
        ListNode three = new ListNode(3);
        three.next = new ListNode(6);

        ListNode result = Merge_k_Sorted_Lists_23.mergeKLists(new ListNode[] {one, two, three});

        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(4, result.next.next.next.val);
        assertEquals(5, result.next.next.next.next.val);
        assertEquals(6, result.next.next.next.next.next.val);
    }
}
