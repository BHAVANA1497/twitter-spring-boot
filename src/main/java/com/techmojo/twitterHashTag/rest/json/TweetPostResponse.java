package com.techmojo.twitterHashTag.rest.json;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TweetPostResponse {

    @ApiModelProperty(value = "Primary Key for this record", required = true, example = "1")
    @NotNull
    private long tweetId;

    @ApiModelProperty(value = "Tweet Entered By User", required = true, example = "Worlds best cricketer is #sachin")
    @NotNull
    @NotBlank
    private String tweet;

    @ApiModelProperty(value = "Date Time at which Tweet is created", required = true, example = "2021-02-18T23:00:00")
    private String tweetCreateTime;


}

