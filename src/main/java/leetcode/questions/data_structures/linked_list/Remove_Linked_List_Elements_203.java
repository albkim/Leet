package leetcode.questions.data_structures.linked_list;

import leetcode.models.ListNode;

/**
 Remove all elements from a linked list of integers that have value val.

 Example
 Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 Return: 1 --> 2 --> 3 --> 4 --> 5


 */
public class Remove_Linked_List_Elements_203 {

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode anchor = new ListNode(-1);

        ListNode previous = anchor;
        ListNode current = head;
        previous.next = current;

        while(current != null) {
            if (current.val == val) {
                previous.next = current.next;
            }
            else {
                previous = current;
            }
            current = current.next;
        }

        return anchor.next;
    }

}
