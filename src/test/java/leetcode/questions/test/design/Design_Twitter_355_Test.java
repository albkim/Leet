package leetcode.test.questions.design;

import leetcode.questions.design.Design_Twitter_355;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by albertk on 9/21/16.
 */
public class Design_Twitter_355_Test {

    @Test
    public void testSimple() {
        Design_Twitter_355 twitter = new Design_Twitter_355();

        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

        // User 1's news feed should return a list with 1 tweet id -> [5].
        List<Integer> result = twitter.getNewsFeed(1);
        assertEquals(1, result.size());
        assertEquals(5, result.get(0).intValue());

        // User 1 follows user 2.
        twitter.follow(1, 2);

        // User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        result = twitter.getNewsFeed(1);
        assertEquals(2, result.size());
        assertEquals(6, result.get(0).intValue());
        assertEquals(5, result.get(1).intValue());

        // User 1 unfollows user 2.
        twitter.unfollow(1, 2);

        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        result = twitter.getNewsFeed(1);
        assertEquals(1, result.size());
        assertEquals(5, result.get(0).intValue());
    }

    @Test
    public void testComplex() {
        Design_Twitter_355 twitter = new Design_Twitter_355();

        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);

        // User 1's news feed should return a list with 1 tweet id -> [5].
        List<Integer> result = twitter.getNewsFeed(1);
        assertEquals(2, result.size());
        assertEquals(3, result.get(0).intValue());
        assertEquals(5, result.get(1).intValue());
    }

    @Test
    public void testCannotFollowSelf() {
        Design_Twitter_355 twitter = new Design_Twitter_355();

        twitter.postTweet(1, 5);
        twitter.follow(1, 1);

        // User 1's news feed should return a list with 1 tweet id -> [5].
        List<Integer> result = twitter.getNewsFeed(1);
        assertEquals(1, result.size());
        assertEquals(5, result.get(0).intValue());
    }

}
