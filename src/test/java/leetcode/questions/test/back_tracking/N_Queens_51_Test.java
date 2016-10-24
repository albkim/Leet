package leetcode.questions.test.back_tracking;

import leetcode.questions.back_tracking.N_Queens_51;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/14/2016.
 */
public class N_Queens_51_Test {

    @Test
    public void testSimple() {
        List<List<String>> result = N_Queens_51.solveNQueens(4);

        assertEquals(2, result.size());

        assertEquals('Q', result.get(0).get(0).charAt(1));
        assertEquals('Q', result.get(0).get(1).charAt(3));
        assertEquals('Q', result.get(0).get(2).charAt(0));
        assertEquals('Q', result.get(0).get(3).charAt(2));

        assertEquals('Q', result.get(1).get(0).charAt(2));
        assertEquals('Q', result.get(1).get(1).charAt(0));
        assertEquals('Q', result.get(1).get(2).charAt(3));
        assertEquals('Q', result.get(1).get(3).charAt(1));
    }

    @Test
    public void testComplex() {
        assertEquals(1, N_Queens_51.solveNQueens(1).size());
        assertEquals(0, N_Queens_51.solveNQueens(2).size());
        assertEquals(0, N_Queens_51.solveNQueens(3).size());
        assertEquals(2, N_Queens_51.solveNQueens(4).size());
        assertEquals(10, N_Queens_51.solveNQueens(5).size());
        assertEquals(4, N_Queens_51.solveNQueens(6).size());
        assertEquals(40, N_Queens_51.solveNQueens(7).size());
        assertEquals(92, N_Queens_51.solveNQueens(8).size());
    }

}
