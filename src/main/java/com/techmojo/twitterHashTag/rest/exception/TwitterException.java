package com.techmojo.twitterHashTag.rest.exception;


public class TwitterException extends RuntimeException{

    public TwitterException(String message){
        super(message);
    }

    public TwitterException(String message, Throwable error){
        super(message, error);
    }

}
