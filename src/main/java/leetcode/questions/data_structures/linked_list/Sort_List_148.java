package leetcode.questions.data_structures.linked_list;

import leetcode.models.ListNode;

/**
 Sort a linked list in O(n log n) time using constant space complexity.

 ----------------------------------------------------------------------------------

 Usually constant space sort with log n complexity is like merge sort...but not sure if
 it's constant space...(log n space it seems)

 */
public class Sort_List_148 {

    public static ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private static ListNode mergeSort(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // at least two elements
        // cut the list in half...this this a lot
        ListNode previous = null;
        ListNode slow = head;
        ListNode fast = head;
        while((slow != null) && (fast != null)) {
            previous = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        // now head holds one copy and slow holds another, cut it!
        previous.next = null;

        // sort eash side
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(slow);

        // merge
        ListNode anchor = new ListNode(-1);
        ListNode newHead = anchor;
        while ((left != null) || (right != null)) {
            // 3 case, either one of them is null or both are not null and i should compare
            if ((left != null) && (right != null)) {
                if (left.val < right.val) {
                    newHead.next = left;
                    left = left.next;
                }
                else {
                    newHead.next = right;
                    right = right.next;
                }
            }
            else if (left == null) {
                newHead.next = right;
                right = right.next;
            }
            else {
                newHead.next = left;
                left = left.next;
            }

            newHead = newHead.next;
        }

        return anchor.next;
    }

}
