package leetcode.questions.test.data_structures.linked_list;

import leetcode.questions.data_structures.linked_list.Add_Two_Numbers_2;
import leetcode.models.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 8/23/2016.
 */
public class Add_Two_Numbers_2_Test {

    @Test
    public void testLeftOnly() {
        ListNode left = new ListNode(1);

        ListNode answer = Add_Two_Numbers_2.addTwoNumbers(left, null);

        assertNotNull(answer);
        assertEquals(1, answer.val);
        assertNull(answer.next);
    }

    @Test
    public void testRightOnly() {
        ListNode right = new ListNode(1);

        ListNode answer = Add_Two_Numbers_2.addTwoNumbers(null, right);

        assertNotNull(answer);
        assertEquals(1, answer.val);
        assertNull(answer.next);
    }

    @Test
    public void testSimple() {
        ListNode left = new ListNode(1);
        ListNode right = new ListNode(1);

        ListNode answer = Add_Two_Numbers_2.addTwoNumbers(left, right);

        assertNotNull(answer);
        assertEquals(2, answer.val);
        assertNull(answer.next);
    }

    @Test
    public void testComplex() {
        ListNode left = new ListNode(1);
        left.next = new ListNode(2);
        ListNode right = new ListNode(1);
        right.next = new ListNode(2);

        ListNode answer = Add_Two_Numbers_2.addTwoNumbers(left, right);

        assertNotNull(answer);
        assertEquals(2, answer.val);
        assertNotNull(answer.next);
        assertEquals(4, answer.next.val);
    }

    @Test
    public void testCarry() {
        ListNode left = new ListNode(5);
        left.next = new ListNode(2);
        ListNode right = new ListNode(5);
        right.next = new ListNode(2);

        ListNode answer = Add_Two_Numbers_2.addTwoNumbers(left, right);

        assertNotNull(answer);
        assertEquals(0, answer.val);
        assertNotNull(answer.next);
        assertEquals(5, answer.next.val);
    }

    @Test
    public void testCarryComplex() {
        ListNode left = new ListNode(5);
        ListNode right = new ListNode(5);

        ListNode answer = Add_Two_Numbers_2.addTwoNumbers(left, right);

        assertNotNull(answer);
        assertEquals(0, answer.val);
        assertNotNull(answer.next);
        assertEquals(1, answer.next.val);
    }

}
