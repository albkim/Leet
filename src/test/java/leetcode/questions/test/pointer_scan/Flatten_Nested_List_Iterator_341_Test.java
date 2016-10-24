package leetcode.questions.test.pointer_scan;

import leetcode.models.NestedInteger;
import leetcode.questions.pointer_scan.Flatten_Nested_List_Iterator_341;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/22/2016.
 */
public class Flatten_Nested_List_Iterator_341_Test {

    public class TestNestedInteger implements NestedInteger {

        private int intValue;
        private List<NestedInteger> listValue;

        public TestNestedInteger(int value) {
            this.intValue = value;
        }

        public TestNestedInteger(List<NestedInteger> value) {
            this.listValue = value;
        }

        @Override
        public boolean isInteger() {
            return this.listValue == null;
        }

        @Override
        public Integer getInteger() {
            return this.intValue;
        }

        @Override
        public List<NestedInteger> getList() {
            return this.listValue;
        }
    }

    @Test
    public void testSimple() {
        List<NestedInteger> firstValue = new ArrayList<>();
        firstValue.add(new TestNestedInteger(1));
        firstValue.add(new TestNestedInteger(1));
        NestedInteger first = new TestNestedInteger(firstValue);

        List<NestedInteger> thirdValue = new ArrayList<>();
        thirdValue.add(new TestNestedInteger(1));
        thirdValue.add(new TestNestedInteger(1));
        NestedInteger third = new TestNestedInteger(thirdValue);

        List<NestedInteger> rootValue = new ArrayList<>();
        rootValue.add(first);
        rootValue.add(new TestNestedInteger(2));
        rootValue.add(third);

        Flatten_Nested_List_Iterator_341 solution = new Flatten_Nested_List_Iterator_341(rootValue);

        int count = 0;
        while(solution.hasNext()) {
            int value = solution.next();
            int result = 0;
            switch(count) {
                case 0: result = 1; break;
                case 1: result = 1; break;
                case 2: result = 2; break;
                case 3: result = 1; break;
                case 4: result = 1; break;
            }
            assertEquals(result, value);
            count++;
        }
    }

}
