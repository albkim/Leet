package leetcode.questions.test.dp;

import leetcode.questions.dp.Edit_Distance_72;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/19/2016.
 */
public class Edit_Distance_72_Test {

    @Test
    public void testSimple() {
        assertEquals(3, Edit_Distance_72.minDistance("sunday", "saturday"));
    }

}
