package com.techmojo.twitterHashTag.rest.controller;


import com.techmojo.twitterHashTag.rest.json.*;
import com.techmojo.twitterHashTag.service.TwitterService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class TwitterHashTagController {

    private final TwitterService twitterService;

    @Autowired
    public TwitterHashTagController(TwitterService twitterService) {this.twitterService = twitterService;}

    @PostMapping(value = "/add/tweet")
    @ApiOperation(value = "Insert Tweet", httpMethod = "POST", consumes = "application/json")
    public RestResponse<TweetPostResponse> addTweet(@RequestBody @Valid TweetPostRequest request) {
        log.info("Tweet Post Request {}", request);
        TweetPostResponse tweetPostResponse;
        RestResponse<TweetPostResponse> restResponse = new RestResponse<>();
        try{
            tweetPostResponse = twitterService.insertTweet(request);
        }
        catch (Exception e){
            log.error(e.getMessage());
            restResponse.setStatus(Status.ERROR);
            restResponse.setMessage(e.getMessage());
            return restResponse;
        }
        restResponse.setData(tweetPostResponse);
        return restResponse;

    }

    @GetMapping(path = "/get/topTenHashtags")
    @ApiOperation(value = "Get Top Ten HashTags", httpMethod = "GET", consumes = "application/json")
    public RestResponse<List<String>> findTopHashTags() {

        RestResponse<List<String>> response = new RestResponse<>();
        List<String> hashTags = twitterService.getTopTenHashTags();
        response.setData(hashTags);
        return response;
    }


}
