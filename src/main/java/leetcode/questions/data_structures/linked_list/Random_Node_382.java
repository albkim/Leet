package leetcode.questions.data_structures.linked_list;

import leetcode.models.ListNode;

import java.util.Random;

/**
 Given a singly linked list, return a random node's value from the linked list.
 Each node must have the same probability of being chosen.

 Follow up: What if the linked list is extremely large and its length is unknown to you?
 Could you solve this efficiently without using extra space?

 Example:
 // Init a singly linked list [1,2,3].
 ListNode head = new ListNode(1);
 head.next = new ListNode(2);
 head.next.next = new ListNode(3);
 Solution solution = new Solution(head);

 // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 solution.getRandom();

 LOL this is a classic reservoir sampling problem
 for sample of 1
    keep the 1st
    for ith item, there is 1/i probability that ith item will replace current
        so for 2, there is 1/2 probability for 2nd, 1st item now has 1 - 1/2 probability that it will be kept
        so for 3, there is 1/3 probability for 3rd, 2nd item now has 1/2 * (1 - 1/3) = 1/3, 1st item now has (1 - 1/2) * (1 - 1/3) = 1/3

 for sample of k
    keep first k
    for ith item, draw a random number from 1 to i. If i is < k, replace ith item from k
        so for ith, there is k/i probability that it will replace an item. For existing item there is k/i * 1/k probability that
        it will be replaced. So overall there is 1/i probability for each item. The numbers surviving ith round is
        k/i (opposite of being replaced 1/i). For i+1, there is 1/(i+1) probability it will be replaced so the probability that
        it will survive is i/(i+1). The probability of surviving both is k/i * i/(i+1) which is k/(i+1)
 */
public class Random_Node_382 {

    private final Random random;
    private final ListNode head;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Random_Node_382(ListNode head) {
        this.random = new Random();
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int count = 1;
        ListNode randomNode = this.head;
        ListNode currentNode = this.head;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
            // should be inclusive to current number, since 2nd should have 0 or 1
            if (this.random.nextInt(count + 1) == 0) {
                randomNode = currentNode;
            }
            count++;
        }
        return randomNode.val;
    }

}
