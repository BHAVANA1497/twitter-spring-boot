package com.techmojo.twitterHashTag.service;


import com.techmojo.twitterHashTag.rest.json.TweetPostRequest;
import com.techmojo.twitterHashTag.rest.json.TweetPostResponse;

import java.util.List;

public interface TwitterService {

    TweetPostResponse insertTweet(TweetPostRequest tweetPostRequest);

    List<String> getTopTenHashTags();


}