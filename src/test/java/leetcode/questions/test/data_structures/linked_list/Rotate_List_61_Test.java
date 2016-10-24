package leetcode.questions.test.data_structures.linked_list;

import leetcode.questions.data_structures.linked_list.Rotate_List_61;
import leetcode.models.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/17/2016.
 */
public class Rotate_List_61_Test {

    @Test
    public void testSimple() {
        ListNode input = new ListNode(1);
        input.next = new ListNode(2);
        input.next.next = new ListNode(3);
        input.next.next.next = new ListNode(4);
        input.next.next.next.next = new ListNode(5);

        ListNode result = Rotate_List_61.rotateRight(input, 2);

        assertEquals(4, result.val);
        assertEquals(5, result.next.val);
        assertEquals(1, result.next.next.val);
        assertEquals(2, result.next.next.next.val);
        assertEquals(3, result.next.next.next.next.val);
    }

    @Test
    public void testZero() {
        ListNode input = new ListNode(1);
        input.next = new ListNode(2);

        ListNode result = Rotate_List_61.rotateRight(input, 0);

        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
    }

    @Test
    public void testOne() {
        ListNode input = new ListNode(1);

        ListNode result = Rotate_List_61.rotateRight(input, 1);

        assertEquals(1, result.val);
    }

    @Test
    public void testOver() {
        ListNode input = new ListNode(1);
        input.next = new ListNode(2);
        input.next.next = new ListNode(3);
        input.next.next.next = new ListNode(4);
        input.next.next.next.next = new ListNode(5);

        ListNode result = Rotate_List_61.rotateRight(input, 7);

        assertEquals(4, result.val);
        assertEquals(5, result.next.val);
        assertEquals(1, result.next.next.val);
        assertEquals(2, result.next.next.next.val);
        assertEquals(3, result.next.next.next.next.val);
    }

}
