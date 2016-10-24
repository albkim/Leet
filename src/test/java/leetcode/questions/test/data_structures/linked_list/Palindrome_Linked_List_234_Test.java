package leetcode.questions.test.data_structures.linked_list;

import leetcode.models.ListNode;
import leetcode.questions.data_structures.linked_list.Palindrome_Linked_List_234;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/15/2016.
 */
public class Palindrome_Linked_List_234_Test {

    @Test
    public void testOdd() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);

        assertTrue(Palindrome_Linked_List_234.isPalindrome(head));
    }

    @Test
    public void testEven() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(1);

        assertTrue(Palindrome_Linked_List_234.isPalindrome(head));
    }

}
