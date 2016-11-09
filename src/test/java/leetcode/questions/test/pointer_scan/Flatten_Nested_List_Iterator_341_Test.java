package leetcode.questions.test.pointer_scan;

import leetcode.models.NestedInteger;
import leetcode.models.NestedIntegerImpl;
import leetcode.questions.pointer_scan.Flatten_Nested_List_Iterator_341;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/22/2016.
 */
public class Flatten_Nested_List_Iterator_341_Test {

    @Test
    public void testSimple() {
        List<NestedInteger> firstValue = new ArrayList<>();
        firstValue.add(new NestedIntegerImpl(1));
        firstValue.add(new NestedIntegerImpl(1));
        NestedInteger first = new NestedIntegerImpl(firstValue);

        List<NestedInteger> thirdValue = new ArrayList<>();
        thirdValue.add(new NestedIntegerImpl(1));
        thirdValue.add(new NestedIntegerImpl(1));
        NestedInteger third = new NestedIntegerImpl(thirdValue);

        List<NestedInteger> rootValue = new ArrayList<>();
        rootValue.add(first);
        rootValue.add(new NestedIntegerImpl(2));
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
