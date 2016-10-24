package leetcode.questions.data_structures.linked_list;

import leetcode.models.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

 Return a deep copy of the list.


 ------------------------------------------------------------------------------------------------------

 dfs out and create random nodes and put it into visited dic, this should be similar to graph duplication

 lol stack overflow...they don't like recursive solutions...

 */
public class Copy_List_Random_Pointer_138 {

    public static RandomListNode copyRandomList(RandomListNode head) {
        Map<Integer, RandomListNode> visited = new HashMap<>();

        return dfsAndCopyIterative(visited, head);
    }

    private static RandomListNode dfsAndCopyIterative(Map<Integer, RandomListNode> visited, RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode copyHead = new RandomListNode(head.label);
        visited.put(copyHead.label, copyHead);

        // since it's a list we are guaranteed that all node should be copied if we just traverse the left;
        RandomListNode current = head;
        RandomListNode copy = copyHead;
        while(current != null) {
            if (current.next != null) {
                copy.next = new RandomListNode(current.next.label);
                visited.put(copy.next.label, copy.next);
            }
            current = current.next;
            copy = copy.next;
        }

        // now just set the random pointer
        current = head;
        copy = copyHead;
        while(current != null) {
            if (current.random != null) {
                copy.random = visited.get(current.random.label);
            }
            current = current.next;
            copy = copy.next;
        }

        return copyHead;
    }

    private static RandomListNode dfsAndCopyRecursive(Map<Integer, RandomListNode> visited, RandomListNode head) {
        if (head == null) {
            return null;
        }

        if (visited.containsKey(head.label)) {
            return visited.get(head.label);
        }

        RandomListNode copy = new RandomListNode(head.label);
        visited.put(copy.label, copy);

        copy.next = dfsAndCopyRecursive(visited, head.next);
        copy.random = dfsAndCopyRecursive(visited, head.random);

        return copy;
    }

}
