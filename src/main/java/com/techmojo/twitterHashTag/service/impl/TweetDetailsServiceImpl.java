package com.techmojo.twitterHashTag.service.impl;


import com.techmojo.twitterHashTag.model.TweetDetails;
import com.techmojo.twitterHashTag.repository.TweetDetailsRepository;
import com.techmojo.twitterHashTag.rest.exception.TwitterException;
import com.techmojo.twitterHashTag.rest.json.TweetCount;
import com.techmojo.twitterHashTag.rest.json.TweetPostRequest;
import com.techmojo.twitterHashTag.rest.json.TweetPostResponse;
import com.techmojo.twitterHashTag.service.TweetDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.MessageFormat;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
@Transactional
public class TweetDetailsServiceImpl implements TweetDetailsService {

    private final ZoneId zoneId = ZoneId.systemDefault();

    private final TweetDetailsRepository tweetDetailsRepository;


    @Autowired
    public TweetDetailsServiceImpl(TweetDetailsRepository tweetDetailsRepository){
        this.tweetDetailsRepository = tweetDetailsRepository;
    }

   /* *
    * This Method allows to insert tweets inside Database
    *
    * TweetId is the primary Auto generated key and
    *
    * createTime is the time when tweet is inserted into Database
    * */
    @Override
    public TweetPostResponse insertTweet(TweetPostRequest tweetPostRequest){

        log.info("create new tweet post record with info {}", tweetPostRequest);

        if(tweetPostRequest.getTweet() == null || tweetPostRequest.getTweet().isEmpty()){
            throw new TwitterException(MessageFormat.format("Tweet cannot be null or Empty {}", tweetPostRequest));
        }

        TweetDetails tweetDetails = new TweetDetails();

        tweetDetails.setTweet(tweetPostRequest.getTweet());

        tweetDetails.setCreateTime(LocalDateTime.now(Clock.system(zoneId)));

        TweetDetails createdTweet = tweetDetailsRepository.save(tweetDetails);

        TweetPostResponse tweetPostResponse = new TweetPostResponse();

        tweetPostResponse.setTweet(createdTweet.getTweet());
        tweetPostResponse.setTweetId(createdTweet.getTweetId());
        tweetPostResponse.setTweetCreateTime(createdTweet.getCreateTime().toString());

        log.info("Tweet Created {}", createdTweet);

        return tweetPostResponse;
    }

    /* *
     *  This Method retrieves all the tweets from the Database
     * */
    @Override
    public List<String> getTopTenHashTags() {

        List<TweetDetails> tweets = tweetDetailsRepository.findAll();

        return topTenHashTags(tweets);

    }

     /* *
     *  This Method is to get top 10 most used Hashtags from the
     * tweets retrieved from Database
     * */
    public List<String> topTenHashTags( List<TweetDetails> tweets){

        Pattern pattern = Pattern.compile("(#\\w+)");
        Matcher match;
        HashMap<String,Integer> hashCounter = new HashMap<>();
        List<TweetCount> tweetCounts = new ArrayList<>();
        List<String> topResult = new ArrayList<>();


        // Finding Hashtag and putting it in Map as key incrementing its count when ever we find it
        // and putting it as value
       for( TweetDetails t : tweets){
           match = pattern.matcher(t.getTweet());
           while (match.find()){
               if(null != hashCounter.get(match.group())){
                   hashCounter.put(match.group(), (hashCounter.get(match.group())+ 1));
               }else{
                   hashCounter.put(match.group(), 1);
               }
           }
       }

       // Converting HashMap to List of objects
        for(String tag : hashCounter.keySet())
        {
            TweetCount t = new TweetCount(hashCounter.get(tag), tag);
            tweetCounts.add(t);
        }

        log.info("before sorting tweets frequency{}", tweetCounts);

        //sort the objects inside List in descending order based on the frequency
        tweetCounts.sort((a, b) -> {
            if (a.getTag().equals(b.getTag()))
                return a.getFrequency() - b.getFrequency();
            else
                return b.getFrequency() - a.getFrequency();
        });
        log.info("after sorting tweets frequency {}", tweetCounts);

        //Returning Top 10 results from the sorted List
        int counter = 1;
        for( TweetCount tweet : tweetCounts){
            topResult.add(tweet.getTag());
            if(counter == 10)
                break;
            counter++;

        }
        log.info("Top 10 Hashtags {}", topResult);
        return topResult;

    }



}
