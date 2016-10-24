package leetcode.questions.data_structures.linked_list;

import leetcode.models.ListNode;

/**
 Given a singly linked list, determine if it is a palindrome.

 Follow up:
 Could you do it in O(n) time and O(1) space?

 ---------------------------------------------------------------------

 find half using two pointer and then reverse the later half...then it's just matter of iterating oe by one

 */
public class Palindrome_Linked_List_234 {

    public static boolean isPalindrome(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return true;
        }

        ListNode previous = null;
        ListNode slow = head;
        ListNode fast = head;

        while ((slow != null) && (fast != null)) {
            previous = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        ListNode rightHead = previous.next;
        ListNode current = slow;
        // now slow would be at middle node or right side of half. If we reverse from slow (and hold on to previous)
        // we will have the other half lined up. (mid could be last element but we don't care)
        previous = null;
        while(current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        ListNode left = head;
        ListNode right = previous;
        while ((left != null) && (right != null) && (left != rightHead)) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

}
