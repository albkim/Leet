package leetcode.questions.data_structures.stack;

import java.util.Stack;

/**
 *
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 • push(x) -- Push element x onto stack.
 • pop() -- Removes the element on top of the stack.
 • top() -- Get the top element.
 • getMin() -- Retrieve the minimum element in the stack.


 Example:

 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.


 -------------------------------------------------------------------------------------

 The simple solution is to use two stack. One as a real stack and another which only keep numbers in min order

 The constant space solution is to store the diff in the min and keep track of the current min. Then one can always
 get the number from the two. Tricky bit is to update current min

 */
public class Min_Stack_155 {

    private Stack<Integer> backing = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public Min_Stack_155() {

    }

    public void push(int x) {
        backing.push(x);
        if (min.empty()) {
            min.push(x);
        }
        else if (x <= min.peek()) {
            // make sure this is == since we could have same value multiple times
            min.push(x);
        }

        // anything below current min root has to be pushed before and doesn't matter
        // since it cannot be the next smallest
    }

    public void pop() {
        int num = backing.pop();

        if (num == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return backing.peek();
    }

    public int getMin() {
        return min.peek();
    }

}
