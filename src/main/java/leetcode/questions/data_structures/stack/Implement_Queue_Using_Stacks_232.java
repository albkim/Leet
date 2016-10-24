package leetcode.questions.data_structures.stack;

import java.util.Stack;

/**
 Implement the following operations of a queue using stacks.
 • push(x) -- Push element x to the back of queue.
 • pop() -- Removes the element from in front of queue.
 • peek() -- Get the front element.
 • empty() -- Return whether the queue is empty.
 Notes:
 •You must use only standard operations of a stack -- which means only push to top,
    peek/pop from top, size, and is empty operations are valid.
 •Depending on your language, stack may not be supported natively. You may simulate a stack by using
    a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 •You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

 ----------------------------------------------------------------------------------------------------------------

 Another classic, we can do this in two ways using two stacks.

    Pop optimized - as we push, move the element out of front to back, push the current, move all elements back to front
    Push optimized - push element into back, during pull see if there is elements in the front, if not, move elements from
                    back to front.

 */
public class Implement_Queue_Using_Stacks_232 {

    private Stack<Integer> front = new Stack<>();
    private Stack<Integer> back = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        while (!this.front.empty()) {
            this.back.push(this.front.pop());
        }

        this.front.push(x);

        while (!this.back.empty()) {
            this.front.push(this.back.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (!this.front.empty()) {
            this.front.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if (!this.front.empty()) {
            return this.front.peek();
        }
        return -1;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return this.front.empty();
    }

}
