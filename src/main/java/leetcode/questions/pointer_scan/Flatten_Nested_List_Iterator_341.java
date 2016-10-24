package leetcode.questions.pointer_scan;

import leetcode.models.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 Given a nested list of integers, implement an iterator to flatten it.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Example 1:
 Given the list [[1,1],2,[1,1]],

 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].


 Example 2:
 Given the list [1,[4,[6]]],

 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].

 -----------------------------------------------------------------------------------------------------------------

 Use a stack to buffer any unconsumed list when i encounter a nested list. and pop it off.


 */
public class Flatten_Nested_List_Iterator_341 implements Iterator<Integer> {

    private Stack<List<NestedInteger>> stack;
    private Integer current;

    public Flatten_Nested_List_Iterator_341(List<NestedInteger> nestedList) {
        this.stack = new Stack<>();
        this.stack.push(nestedList);
        this.peel();
    }

    @Override
    public Integer next() {
        if (this.current == null) {
            return null;
        }

        Integer current = this.current;
        this.peel();
        return current;
    }

    @Override
    public boolean hasNext() {
        return this.current != null;
    }

    private void peel() {
        while(true) {
            if (this.stack.empty()) {
                this.current = null;
                break;
            }

            List<NestedInteger> top = this.stack.peek();
            if (top.size() == 0) {
                this.stack.pop();
                continue;
            }

            NestedInteger first = top.get(0);
            top.remove(0);
            if (top.size() == 0) {
                this.stack.pop();
            }

            if (first.isInteger()) {
                this.current = first.getInteger();
                break;
            }
            else {
                top = first.getList();

                if (top.size() > 0) {
                    this.stack.push(top);
                }
            }
        }
    }

}
