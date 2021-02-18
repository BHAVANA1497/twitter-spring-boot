package com.techmojo.twitterHashTag.service;

import com.techmojo.twitterHashTag.model.TweetDetails;
import com.techmojo.twitterHashTag.repository.TweetDetailsRepository;
import com.techmojo.twitterHashTag.rest.json.TweetPostRequest;
import com.techmojo.twitterHashTag.rest.json.TweetPostResponse;
import com.techmojo.twitterHashTag.service.impl.TwitterServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class TwitterServiceImplTest {


    @Mock
    TweetDetailsRepository tweetDetailsRepository;

    @InjectMocks
    TwitterServiceImpl twitterService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testInsertTweet(){

        TweetDetails tweetDetails = new TweetDetails(1, "#new tweet", LocalDateTime.now());

         TweetPostRequest tweetPostRequest = new TweetPostRequest(1, "#new tweet");

        when(tweetDetailsRepository.save(tweetDetails)).thenReturn(new TweetDetails(1, "#new tweet", LocalDateTime.now()));

       // TweetPostResponse result = twitterService.insertTweet(tweetPostRequest);

//        Assertions.assertAll("Tweet Details",
//                () -> Assertions.assertEquals(1, result.getTweetId()),
//                () -> Assertions.assertEquals("#new tweet", result.getTweet())
//        );
    }

    @Test
    void testGetTopTenHashTags(){

        TweetDetails tweetDetails = new TweetDetails(1, "#new tweet", LocalDateTime.now());

        when(tweetDetailsRepository.findAll()).thenReturn(Arrays.asList(tweetDetails));

       List<String> result =   twitterService.getTopTenHashTags();

//        Assertions.assertAll("Tweet Details",
//                () -> Assertions.assertEquals(1, result.getTweetId()),
//                () -> Assertions.assertEquals("#new tweet", result.getTweet())
//        );
    }





}
