package leetcode.questions.data_structures.linked_list;

import leetcode.models.ListNode;

/**
 Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.

 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5

 When I am reversing a list it works like this
 A - B - C
 T = C
 B -> A
 T -> B

 What if I combine this with nth pointer which will call itself with next element
 If nth pointer is null (then return the current head)
 */
public class Reverse_Nodes_K_Group_25 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode nth = head;
        // nth check
        for (int count = 0; count < (k - 1); count++) {
            if (nth != null) {
                nth = nth.next;
            }
        }

        if (nth == null) {
            return head;
        }

        // take ref of next
        ListNode neighbor = nth.next;

        // now we have enough items to reverse
        reverseGroup(head, k - 1);

        // relink the neighbors
        // this also means, we need to look at the neighbors
        head.next = reverseKGroup(neighbor, k);

        return nth;
    }

    // simple reverse linked list
    // head = 1, next = 2, 2->1, return 4
    // head = 2, next = 3, 3->2, return 4
    // head = 3, next = 4, 4->3, return 4
    // return 4
    private static ListNode reverseGroup(ListNode head, int remaining) {
        if (remaining == 0) {
            return head;
        }

        ListNode next = head.next;
        if (next == null) {
            return head;
        }

        ListNode temp = reverseGroup(next, remaining - 1);
        next.next = head;
        head.next = null;
        return temp;
    }
}
