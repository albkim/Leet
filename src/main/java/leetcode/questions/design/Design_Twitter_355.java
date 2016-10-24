package leetcode.questions.design;

import java.util.*;

/**
 Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and
 is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

 1.	postTweet(userId, tweetId): Compose a new tweet.
 2.	getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the
 news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
 3.	follow(followerId, followeeId): Follower follows a followee.
 4.	unfollow(followerId, followeeId): Follower unfollows a followee.

 Example:
 Twitter twitter = new Twitter();

 // User 1 posts a new tweet (id = 5).
 twitter.postTweet(1, 5);

 // User 1's news feed should return a list with 1 tweet id -> [5].
 twitter.getNewsFeed(1);

 // User 1 follows user 2.
 twitter.follow(1, 2);

 // User 2 posts a new tweet (id = 6).
 twitter.postTweet(2, 6);

 // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 twitter.getNewsFeed(1);

 // User 1 unfollows user 2.
 twitter.unfollow(1, 2);

 // User 1's news feed should return a list with 1 tweet id -> [5],
 // since user 1 is no longer following user 2.
 twitter.getNewsFeed(1);


 ----------------------------------------------------------------------------------------

 Seems more like a design question, fan out/fan in, pre materialization vs runtime query

 Looks like the simplest solution is to use a priority queue to do sort of n followee as the feed is requested

 */
public class Design_Twitter_355 {
    /**
     * Your Twitter object will be instantiated and called as such:
     * Twitter obj = new Twitter();
     * obj.postTweet(userId,tweetId);
     * List<Integer> param_2 = obj.getNewsFeed(userId);
     * obj.follow(followerId,followeeId);
     * obj.unfollow(followerId,followeeId);
     */

    private class Tweet {
        public int time;
        public int value;

        public Tweet(int time, int value) {
            this.time = time;
            this.value = value;
        }
    }

    private class TweetSearcher {
        public List<Tweet> tweets;
        public int currentIndex;

        public TweetSearcher(List<Tweet> tweets){
            this.tweets = tweets;
            this.currentIndex = tweets.size() - 1;
        }
    }

    // tracks tweets for a given user. We could use a stack but LIFO behavior
    // but we would have to pop and push back in...why incur extra operation when
    // we can just scan the list from the back
    private int time;
    private Map<Integer, List<Tweet>> tweets = new HashMap<>();
    private Map<Integer, Set<Integer>> followers = new HashMap<>();

    /** Initialize your data structure here. */
    public Design_Twitter_355() {
        // not needed but why not
        this.time = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        this.time++;

        if (this.tweets.containsKey(userId)) {
            this.tweets.get(userId).add(new Tweet(this.time, tweetId));
        }
        else {
            List<Tweet> list = new ArrayList<>();
            list.add(new Tweet(this.time, tweetId));
            this.tweets.put(userId, list);
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Queue<TweetSearcher> ranker = new PriorityQueue<>(new Comparator<TweetSearcher>() {
            @Override
            public int compare(TweetSearcher o1, TweetSearcher o2) {
                // compare the last element
                int left = o1.tweets.get(o1.currentIndex).time;
                int right = o2.tweets.get(o2.currentIndex).time;

                // cannot be the same since time is incremental here

                // desc
                return (left < right) ? 1 : -1;
            }
        });

        if (this.followers.containsKey(userId)) {
            // first populate the ranker
            for (int followeeId : this.followers.get(userId)) {
                if (this.tweets.containsKey(followeeId)) {
                    ranker.add(new TweetSearcher(this.tweets.get(followeeId)));
                }
            }
        }

        // populate with user/self
        if (this.tweets.containsKey(userId)) {
            ranker.add(new TweetSearcher(this.tweets.get(userId)));
        }

        // now try to pop the latest
        List<Integer> result = new ArrayList<>();
        while ((!ranker.isEmpty()) && (result.size() < 10)) {
            TweetSearcher current = ranker.poll();

            result.add(current.tweets.get(current.currentIndex).value);
            current.currentIndex--;

            if (current.currentIndex >= 0) {
                ranker.add(current);
            }
        }

        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        Set<Integer> followees;
        if (this.followers.containsKey(followerId)) {
            followees = this.followers.get(followerId);
        }
        else {
            followees = new HashSet<>();
            this.followers.put(followerId, followees);
        }

        if (!followees.contains(followeeId)) {
            followees.add(followeeId);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {

        if (followerId == followeeId) {
            return;
        }

        if (this.followers.containsKey(followerId)) {
            Set<Integer> followees = this.followers.get(followerId);
            if (followees.contains(followeeId)) {
                followees.remove(followeeId);
            }
        }
    }

}
