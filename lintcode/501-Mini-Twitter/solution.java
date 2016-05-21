/**
 * Definition of Tweet:
 * public class Tweet {
 *     public int id;
 *     public int user_id;
 *     public String text;
 *     public static Tweet create(int user_id, String tweet_text) {
 *         // This will create a new tweet object,
 *         // and auto fill id
 *     }
 * }
 */
public class MiniTwitter {

    HashMap<Integer, LinkedList<Tweet>> feeds;
    HashMap<Integer, HashSet<Integer>> follows;

    public class TweetComparator implements Comparator<Tweet> {
        @Override
        public int compare(Tweet a, Tweet b) {
            if (a.id > b.id) {
                return 1;
            } else if (a.id < b.id) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public MiniTwitter() {
        feeds = new HashMap<Integer, LinkedList<Tweet>>();
        follows = new HashMap<Integer, HashSet<Integer>>();
    }

    public Tweet postTweet(int user_id, String tweet_text) {
        Tweet tweet = Tweet.create(user_id, tweet_text);

        // put tweet to linkedlist
        if (!feeds.containsKey(user_id)) {
            feeds.put(user_id, new LinkedList<Tweet>());
        }

        feeds.get(user_id).addFirst(tweet);

        return tweet;
    }

    public List<Tweet> getNewsFeed(int user_id) {
        // get all user_id
        ArrayList<Integer> userIds = new ArrayList<Integer>();
        // if not follow anyone
        if (!follows.containsKey(user_id)) {
            return getTimeline(user_id);
        }

        HashSet<Integer> friendIds = follows.get(user_id);
        friendIds.add(user_id);

        List<Tweet> list = new LinkedList<Tweet>();
        for (int fid : friendIds) {
            list.addAll(getTimeline(fid));
        }
        Collections.sort(list, Collections.reverseOrder(new TweetComparator()));

        // remove feeds if > 10
        if (list.size() > 10) {
            list.subList(10, list.size()).clear();
        }

        return list;
    }

    public List<Tweet> getTimeline(int user_id) {
        List<Tweet> list = new LinkedList<Tweet>();
        if (feeds.containsKey(user_id)) {
            List<Tweet> allFeed = feeds.get(user_id);
            int len = allFeed.size() >= 10 ? 10 : allFeed.size();
            // traverse the list
            ListIterator<Tweet> listIterator = allFeed.listIterator();
            for (int i = 0; i < len; i++) {
                list.add(listIterator.next());
            }
        }
        return list;
    }

    public void follow(int from_user_id, int to_user_id) {
        if (!follows.containsKey(from_user_id)) {
            follows.put(from_user_id, new HashSet<Integer>());
        }
        follows.get(from_user_id).add(to_user_id);
    }

    public void unfollow(int from_user_id, int to_user_id) {
        if (!follows.containsKey(from_user_id)) {
            return;
        }
        follows.get(from_user_id).remove(to_user_id);
    }
}