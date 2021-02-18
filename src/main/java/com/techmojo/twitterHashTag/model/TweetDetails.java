package com.techmojo.twitterHashTag.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Table(name = "TWEET_DETAILS")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TweetDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TWEET_ID")
    private long tweetId;

    @Column (name = "tweet_desc")
    private String tweet;

    @Column (name = "CREATE_TIME")
    private LocalDateTime createTime;


}
