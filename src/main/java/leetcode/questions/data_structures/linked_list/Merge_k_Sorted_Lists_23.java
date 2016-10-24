package leetcode.questions.data_structures.linked_list;

import leetcode.models.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

 */
public class Merge_k_Sorted_Lists_23 {

    public static ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val == o2.val) {
                    return 0;
                }
                return (o1.val < o2.val) ? -1 : 1;
            }
        });

        // first populate the queue;
        for(ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        ListNode fakeHead = new ListNode(-1);

        ListNode current = fakeHead;
        while(minHeap.size() > 0) {
            // find lowest
            ListNode lowest = minHeap.poll();
            current.next = lowest;

            if (lowest.next != null) {
                minHeap.add(lowest.next);
            }
            current = current.next;
        }
        return fakeHead.next;
    }

}
