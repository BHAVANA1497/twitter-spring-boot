package com.techmojo.twitterHashTag.controller;

import com.techmojo.twitterHashTag.rest.controller.TweetDetailsController;
import com.techmojo.twitterHashTag.rest.json.RestResponse;
import com.techmojo.twitterHashTag.rest.json.TweetPostRequest;
import com.techmojo.twitterHashTag.rest.json.TweetPostResponse;
import com.techmojo.twitterHashTag.service.TweetDetailsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

public class TweetDetailsTestController {

    @Mock
    TweetDetailsService tweetDetailsService;

    @InjectMocks
    TweetDetailsController tweetDetailsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this); }


    @DisplayName("Test Add Tweet to Database")
    @Test
    void testAddTweet(){
        when(tweetDetailsService.insertTweet(new TweetPostRequest(1, "#new tweet"))).thenReturn(new TweetPostResponse(1, "#new tweet", LocalDateTime.now().toString()));

        RestResponse<TweetPostResponse> result = tweetDetailsController.addTweet(new TweetPostRequest(1, "#new tweet"));

        Assertions.assertAll("Tweet Details",
                () -> Assertions.assertEquals(1, result.getData().getTweetId()),
                () -> Assertions.assertEquals("#new tweet", result.getData().getTweet())
        );
    }


}
