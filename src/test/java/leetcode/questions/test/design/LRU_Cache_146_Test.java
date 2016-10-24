package leetcode.questions.test.design;

import leetcode.questions.design.LRU_Cache_146;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/8/2016.
 */
public class LRU_Cache_146_Test {

    @Test
    public void testBasic() {
        LRU_Cache_146 cache = new LRU_Cache_146(Integer.MAX_VALUE);

        cache.set(1, 2);

        assertEquals(2, cache.get(1));
    }

    @Test
    public void testReset() {
        LRU_Cache_146 cache = new LRU_Cache_146(Integer.MAX_VALUE);

        cache.set(1, 2);
        cache.set(1, 3);

        assertEquals(3, cache.get(1));
    }

    @Test
    public void testEvict() {
        LRU_Cache_146 cache = new LRU_Cache_146(1);

        cache.set(1, 2);
        cache.set(2, 3);

        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(2));
    }

    @Test
    public void testEvictReorder() {
        LRU_Cache_146 cache = new LRU_Cache_146(2);

        cache.set(1, 2);
        cache.set(2, 3);
        cache.get(1);
        cache.set(3, 4);

        assertEquals(-1, cache.get(2));
        assertEquals(2, cache.get(1));
    }

    @Test
    public void testEvictReorder2() {
        LRU_Cache_146 cache = new LRU_Cache_146(2);

        cache.set(2, 1);
        cache.set(1, 1);
        cache.set(2, 3);
        cache.set(4, 1);

        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(2));
    }

}
