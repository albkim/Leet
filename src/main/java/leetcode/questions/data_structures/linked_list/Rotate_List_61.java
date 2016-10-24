package leetcode.questions.data_structures.linked_list;

import leetcode.models.ListNode;

/**
 Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.


 ---------------------------------------------------------------------------------------

 Have another pointer that's moving k node earlier and then just rewrite refs

 Looks like the trick is to how to wrap around if k moves out of the tail...since k == length is a full rotation

 */
public class Rotate_List_61 {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int count = 0;
        ListNode kNode = head;
        while(count < k) {
            if (kNode.next == null) {
                // we have reached the end.
                kNode = head;
                int length = count + 1;
                count = (k / length) * length;
            }
            else {
                kNode = kNode.next;
                count++;
            }
        }

        if (head == kNode) {
            return head;
        }

        ListNode pointer = head;
        while(kNode.next != null) {
            kNode = kNode.next;
            pointer = pointer.next;
        }

        ListNode newHead = pointer.next;
        kNode.next = head;
        pointer.next = null;
        return newHead;
    }

}
