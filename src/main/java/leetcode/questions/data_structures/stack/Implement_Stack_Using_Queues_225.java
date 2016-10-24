package leetcode.questions.data_structures.stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 Implement the following operations of a stack using queues.
 • push(x) -- Push element x onto stack.
 • pop() -- Removes the element on top of the stack.
 • top() -- Get the top element.
 • empty() -- Return whether the stack is empty.
 Notes:
 •You must use only standard operations of a queue -- which means only push to back, peek/pop from front,
 size, and is empty operations are valid.
 •Depending on your language, queue may not be supported natively. You may simulate a queue by using a list
 or deque (double-ended queue), as long as you use only standard operations of a queue.
 •You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

 ------------------------------------------------------------------------------------------------

 Classic question. Do it with 2 queues. The naive solution is to store reversed version of data in the front queue
 */
public class Implement_Stack_Using_Queues_225 {

    private Queue<Integer> front = new ArrayDeque<>();
    private Queue<Integer> back = new ArrayDeque<>();

    // Push element x onto stack.
    public void push(int x) {
        // front is always in reverse order
        this.back.add(x);

        while(!this.front.isEmpty()) {
            this.back.add(this.front.poll());
        }

        Queue<Integer> tmp = this.front;
        this.front = this.back;
        this.back = tmp;
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (!this.front.isEmpty()) {
            this.front.remove();
        }
    }

    // Get the top element.
    public int top() {
        if (!this.front.isEmpty()) {
            return this.front.peek();
        }
        return -1;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return this.front.isEmpty();
    }

}
