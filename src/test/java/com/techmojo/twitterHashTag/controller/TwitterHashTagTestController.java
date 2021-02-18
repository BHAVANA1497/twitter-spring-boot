package com.techmojo.twitterHashTag.controller;

import com.techmojo.twitterHashTag.rest.controller.TwitterHashTagController;
import com.techmojo.twitterHashTag.rest.json.RestResponse;
import com.techmojo.twitterHashTag.rest.json.TweetPostRequest;
import com.techmojo.twitterHashTag.rest.json.TweetPostResponse;
import com.techmojo.twitterHashTag.service.TwitterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class TwitterHashTagTestController {

    @Mock
    TwitterService twitterService;

    @InjectMocks
    TwitterHashTagController twitterHashTagController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this); }


    @DisplayName("Test Add Tweet to Database")
    @Test
    void testAddTweet(){
        when(twitterService.insertTweet(new TweetPostRequest(1, "#new tweet"))).thenReturn(new TweetPostResponse(1, "#new tweet", LocalDateTime.now().toString()));

        RestResponse<TweetPostResponse> result = twitterHashTagController.addTweet(new TweetPostRequest(1, "#new tweet"));

        Assertions.assertAll("Tweet Details",
                () -> Assertions.assertEquals(1, result.getData().getTweetId()),
                () -> Assertions.assertEquals("#new tweet", result.getData().getTweet())
        );
    }






}
