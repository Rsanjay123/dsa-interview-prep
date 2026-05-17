package DSAPREP.SystemDesign;

import java.util.*;

public class Twitter {

  public static void main(String[] args) {
    Twitter twitter = new Twitter();
    twitter.postTweet(1, 5);
    System.out.println(twitter.getNewsFeed(1));
    twitter.follow(1, 2);
    twitter.postTweet(2, 6);
    System.out.println(twitter.getNewsFeed(1));
    twitter.unfollow(1, 2);
    System.out.println(twitter.getNewsFeed(1));
  }

  public static int time = 0;
  class Tweet {
    int id;
    int time;
    public Tweet(int id, int time) {
      this.id = id;
      this.time = time;
    }
  }
  Map<Integer, Set<Integer>> followMap;
  Map<Integer, List<Tweet>> tweetMap;

  public Twitter() {
    this.followMap = new HashMap<>();
    this.tweetMap = new HashMap<>();
  }

  public void postTweet(int userId, int tweetId) {
    tweetMap.putIfAbsent(userId, new ArrayList<>());
    tweetMap.get(userId).add(new Tweet(tweetId, time++));
  }

  public List<Integer> getNewsFeed(int userId) {
    PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a,b) -> b.time - a.time);
    if(tweetMap.containsKey(userId)) {
      maxHeap.addAll(tweetMap.get(userId));
    }

    followMap.putIfAbsent(userId, new HashSet<>());
    for(int followee: followMap.get(userId)) {
      if(tweetMap.containsKey(followee)) {
        maxHeap.addAll(tweetMap.get(followee));
      }
    }
    List<Integer> result = new ArrayList<>();
    while(!maxHeap.isEmpty() && result.size() < 10) {
      result.add(maxHeap.poll().id);
    }
    return result;
  }

  public void follow(int followerId, int followeeId) {
    followMap.putIfAbsent(followerId, new HashSet<>());
    if(followMap.containsKey(followerId)) {
      followMap.get(followerId).add(followeeId);
    }
  }

  public void unfollow(int followerId, int followeeId) {
    if(followMap.containsKey(followerId)) {
      followMap.get(followerId).remove(followeeId);
    }
  }

}
