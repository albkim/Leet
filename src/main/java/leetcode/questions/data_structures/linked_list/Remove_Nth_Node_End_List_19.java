package leetcode.questions.data_structures.linked_list;

import leetcode.models.ListNode;

/**
 Given a linked list, remove the nth node from the end of list and return its head.

 For example,
 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.


 Note:
 Given n will always be valid.
 Try to do this in one pass.

 pretty simple, just need another pointer moving n faster, when that reaches tail (no next), then we are at
 nth - 1 node from the back.
 */
public class Remove_Nth_Node_End_List_19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode tail = current;
        for (int count = 0; count < n - 1; count++) {
            // says n is valid, so we don't need to do any check
            tail = tail.next;
        }

        ListNode previous = null;
        while(tail.next != null) {
            tail = tail.next;
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            // we remove head
            if (head.next == null) {
                return null;
            }
            else {
                return head.next;
            }
        }

        // now current should be at nth - 1 node from end
        previous.next = current.next;
        current.next = null;

        return head;
    }

}
