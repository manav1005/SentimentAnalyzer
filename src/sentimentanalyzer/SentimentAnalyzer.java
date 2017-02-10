/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentimentanalyzer;
import twitter4j.*;
import java.util.List;
import java.util.ArrayList;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.TwitterFactory;

/**
 *
 * @author Manav
 */
public class SentimentAnalyzer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConfigurationBuilder cb=new ConfigurationBuilder();
        cb.setDebugEnabled(true).setOAuthConsumerKey("2u0Pr0nApKkZYKMhkgymXS3zg")
                .setOAuthConsumerSecret("MHdm8mA5Ba3UQerzbDjg4rFTPQb7jtdd38Dv0rrlSEvRD3E3XC")
                .setOAuthAccessToken("829974056174710785-f9MtpkICtKDzNKxVeJGVKFk1F1MjyNe")
                .setOAuthAccessTokenSecret("VClbXFMZrpU40ORJDt9mKEohAUdbz2kRM0uFNKRXanmsY");
        
        
        TwitterFactory tf=new TwitterFactory(cb.build());
         Twitter twitter = tf.getInstance();
        try {
            Query query = new Query("Obama");
            QueryResult result;
            result = twitter.search(query);
            List<Status> tweets = result.getTweets();
            for (Status tweet : tweets) {
                System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
            }

            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
        
       
}
        
        List<Status> tweets = new ArrayList<Status>();

void getTweets(String term)
{
int wantedTweets = 10000;
long lastSearchID = Long.MAX_VALUE;
int remainingTweets = wantedTweets;
Query query = new Query(term);
 try
{ 

  while(remainingTweets > 0)
  {
    remainingTweets = wantedTweets - tweets.size();
    if(remainingTweets > 100)
    {
      query.count(100);
    }
    else
    {
     query.count(remainingTweets); 
    }
    QueryResult result = twitter.search(query);
    tweets.addAll(result.getTweets());
    Status s = tweets.get(tweets.size()-1);
    firstQueryID = s.getId();
    query.setMaxId(firstQueryID);
    remainingTweets = wantedTweets - tweets.size();
  }

  println("tweets.size() "+tweets.size() );
}
catch(TwitterException te)
{
  System.out.println("Failed to search tweets: " + te.getMessage());
  System.exit(-1);
}
}
        
    }


   
