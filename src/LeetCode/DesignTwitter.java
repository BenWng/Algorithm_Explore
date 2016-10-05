package LeetCode;

/**
 * Created by Ben_Big on 10/5/16.
 */

import java.sql.Timestamp;
import java.util.*;

/**
 * 355. Design Twitter
 Question
 Editorial Solution
 My Submissions

 •	Total Accepted: 8484
 •	Total Submissions: 35804
 •	Difficulty: Medium

 Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

 1	postTweet(userId, tweetId): Compose a new tweet.
 2	getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
 3	follow(followerId, followeeId): Follower follows a followee.
 4	unfollow(followerId, followeeId): Follower unfollows a followee.

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

 */


class post{
    private static int time=0;

    int id;
    int creatorId;
    int timeCreated;
    post(int id,int creatorId){
        this.id=id;
        this.creatorId=creatorId;
        time++;
        timeCreated=time;
    }
}

class MyComp implements Comparator<post>{
    public int compare(post postA,post postB){
        if(postA.timeCreated<postB.timeCreated){
            return 1;
        }
        else{
            return -1;
        }
    }
}




public class DesignTwitter {
    HashMap<Integer,TreeSet<post>> allPosts;//the integer key corresponds to the user ID;
    HashMap<Integer,HashSet<Integer>> allFollowingList;//the integer key corresponds to the user ID;

    public DesignTwitter(){
        allPosts=new HashMap<>();
        allFollowingList=new HashMap<>();
    }


    public void postTweet(int userId, int postId){
        if (allPosts.containsKey(userId)){
            TreeSet<post> thisUsersPosts=allPosts.get(userId);
            thisUsersPosts.add(new post(postId,userId));
        }
        else{
            TreeSet<post> newUsersPosts=new TreeSet<>(new MyComp());
            newUsersPosts.add(new post(postId,userId));
            allPosts.put(userId,newUsersPosts);
        }
    }

    public void follow(int followerId, int followingId){
        if (followerId!=followingId) {
            if (allFollowingList.containsKey(followerId)) {
                HashSet<Integer> peopleFollowing = allFollowingList.get(followerId);
                peopleFollowing.add(followingId);
            } else {
                HashSet<Integer> newUsersFollowingList = new HashSet<>();
                newUsersFollowingList.add(followingId);
                allFollowingList.put(followerId, newUsersFollowingList);
            }
        }

    }


    public void unfollow(int followerId, int followingId){
        if (allFollowingList.containsKey(followerId)){
            HashSet<Integer> peopleFollowing=allFollowingList.get(followerId);
            peopleFollowing.remove(followingId);
        }
    }

    public List<Integer> getNewsFeed(int userId){
        TreeSet<post> postsCache=new TreeSet<>(new MyComp());
        HashSet<Integer> followingList=allFollowingList.get(userId);
        if(followingList!=null) {
            Iterator<Integer> itr = followingList.iterator();
            //Add the posts of those this person is following into postsCache
            while (itr.hasNext()) {
                Integer followingId = itr.next();
                TreeSet<post> followingsPosts = allPosts.get(followingId);
                if (followingsPosts!=null) {
                    Iterator<post> innerItr = followingsPosts.iterator();
                    for (int i = 0; i < 10 && innerItr.hasNext(); i++) {
                        postsCache.add(innerItr.next());
                    }
                }
            }
        }
        //Add the person's own posts
        TreeSet<post> ownPosts=allPosts.get(userId);
        if (ownPosts!=null) {
            Iterator<post> itr2 = ownPosts.iterator();
            for (int i = 0; i < 10 && itr2.hasNext(); i++) {
                postsCache.add(itr2.next());
            }
        }

        //Return the 10 most recent posts
        ArrayList<Integer> result =new ArrayList<>();
        Iterator<post> itr3=postsCache.iterator();
        for (int i=0;i<10&& itr3.hasNext();i++){
            result.add(itr3.next().id);
        }

        return result;
    }



    public static void main(String[] args){

        DesignTwitter dt=new DesignTwitter();
        //Tests for postTweet
        dt.postTweet(1,3);
        dt.postTweet(1,1);
        dt.postTweet(1,0);
        dt.postTweet(2,3);
        System.out.println(dt.allPosts.get(1).pollFirst().id);
        dt.postTweet(1,234);
        System.out.println(dt.allPosts.get(1).pollFirst().id);
        System.out.println(dt.allPosts.get(1).pollFirst().id);
        //Tests for follow and unfollow
        dt.follow(1,3);
        dt.follow(1,5);
        dt.follow(3,1);
        dt.unfollow(1,5);

        //Test for getNewsFeed
        DesignTwitter dt2=new DesignTwitter();
        dt2.postTweet(1,32);
        dt2.postTweet(1,24);
        dt2.postTweet(2,3);
        dt2.follow(2,1);
        System.out.println(dt2.getNewsFeed(2));
        dt2.unfollow(2,1);
        System.out.println(dt2.getNewsFeed(2));
        dt2.postTweet(1,18);
        dt2.follow(2,1);
        System.out.println(dt2.getNewsFeed(2));


        DesignTwitter dt3=new DesignTwitter();
        dt3.postTweet(1,5);
        dt3.postTweet(1,3);
        dt3.getNewsFeed(1);
        System.out.println(dt3.getNewsFeed(1));



    }




}
