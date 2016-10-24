package leetcode.questions.data_structures.linked_list;

import leetcode.models.ListNode;

/**
 You are given two linked lists representing two non-negative number. The digits are stored in reverse order and each of
 their nodes contain a single digit. Add the two number and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8

 Seems like two pointer moving until both ends and just summing up with basic overflow tracking
 */
public class Add_Two_Numbers_2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        ListNode left = l1;
        ListNode right = l2;
        ListNode answer = null;
        ListNode currentAnswer = null;
        while((left != null) || (right != null) || (carry)) {
            // calculate carry
            int value = (carry) ? 1 : 0;

            // calculate left
            if (left != null) {
                value += left.val;
                left = left.next;
            }

            // calculate right
            if (right != null) {
                value += right.val;
                right = right.next;
            }

            // check for carry
            if (value > 9) {
                carry = true;
                value = value % 10;
            }
            else {
                carry = false;
            }

            // compose answer
            if (answer == null) {
                answer = new ListNode(value);
                currentAnswer = answer;
            }
            else {
                currentAnswer.next = new ListNode(value);
                currentAnswer = currentAnswer.next;
            }
        }

        return answer;
    }

}
