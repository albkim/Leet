package leetcode.questions.data_structures.linked_list;

import leetcode.models.ListNode;

/**
 Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.



 ------------------------------------------------------------------------------------------------

 Skip the pointer if encounter dupe


 */
public class Remove_Duplicates_Sorted_List_83 {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = head;

        ListNode last = newHead;
        ListNode current = head.next;
        while(current != null) {
            if (current.val == last.val) {
                // dupe
                last.next = null;
            }
            else {
                last.next = current;
                last = current;
            }
            current = current.next;
        }

        return newHead;
    }


}
