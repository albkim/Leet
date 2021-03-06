package leetcode.questions.data_structures.linked_list;

import leetcode.models.ListNode;

/**
 Merge two sorted linked lists and return it as a new list.
 The new list should be made by splicing together the nodes of the first two lists.

 */
public class Merge_Two_Sorted_Lists_21 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // fake head
        ListNode head = new ListNode(-1);

        ListNode current = head;
        while((l1 != null) && (l2 != null)) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            }
            else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // remainder
        if (l1 != null) {
            current.next = l1;
        }
        else {
            current.next = l2;
        }

        return head.next;
    }

}
