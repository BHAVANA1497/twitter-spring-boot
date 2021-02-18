package com.techmojo.twitterHashTag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.techmojo")
public class TwitterHashTagApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterHashTagApplication.class, args);
	}

}
