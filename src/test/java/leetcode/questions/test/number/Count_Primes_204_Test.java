package leetcode.questions.test.number;

import leetcode.questions.number.Count_Primes_204;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/11/2016.
 */
public class Count_Primes_204_Test {

    @Test
    public void testSimple() {
        assertEquals(4, Count_Primes_204.countPrimes(8));
        assertEquals(8, Count_Primes_204.countPrimes(20));
    }

    @Test
    public void testSlow() {
        assertEquals(41537, Count_Primes_204.countPrimes(499979));
        assertEquals(114155, Count_Primes_204.countPrimes(1500000));
    }

}
