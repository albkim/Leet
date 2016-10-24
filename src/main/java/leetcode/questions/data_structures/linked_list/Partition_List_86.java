package leetcode.questions.data_structures.linked_list;

import leetcode.models.ListNode;

/**
 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.


 ----------------------------------------------------------------------------------------------------

 As we scan, we just need to append to another linked list

 */
public class Partition_List_86 {

    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode fakeHead1 = new ListNode(-1);
        ListNode left = fakeHead1;
        ListNode fakeHead2 = new ListNode(-1);
        ListNode right = fakeHead2;
        while(head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
            }
            else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        right.next = null;
        left.next = fakeHead2.next;
        return fakeHead1.next;
    }

}
