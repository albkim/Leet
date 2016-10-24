package leetcode.questions.data_structures.linked_list;

import leetcode.models.RandomListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/7/2016.
 */
public class Copy_List_Random_Pointer_138_Test {

    @Test
    public void testSimple() {
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.next.next.next = new RandomListNode(4);
        head.random = head.next.next.next;
        head.next.next.random = head;

        RandomListNode copy = Copy_List_Random_Pointer_138.copyRandomList(head);

        assertEquals(1, copy.label);
        assertEquals(2, copy.next.label);
        assertEquals(3, copy.next.next.label);
        assertEquals(4, copy.next.next.next.label);

        assertEquals(4, copy.random.label);
        assertEquals(1, copy.next.next.random.label);
    }

}
