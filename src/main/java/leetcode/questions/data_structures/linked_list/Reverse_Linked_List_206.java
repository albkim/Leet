package leetcode.questions.data_structures.linked_list;

import leetcode.models.ListNode;

/**
 Reverse a singly linked list.
 */
public class Reverse_Linked_List_206 {

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode previous = null;
        ListNode current = head;

        while(current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

}
