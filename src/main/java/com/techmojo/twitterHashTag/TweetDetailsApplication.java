package com.techmojo.twitterHashTag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.techmojo")
public class TweetDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TweetDetailsApplication.class, args);
	}

}
