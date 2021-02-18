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
public class TweetPostRequest{

    @ApiModelProperty(value = "Primary Key for this record", required = true, example = "1", hidden = true)
    @NotNull
    private long tweetId;

    @ApiModelProperty(value = "Tweet Entered By User", required = true, example = "Worlds best cricketer is #sachin")
    @NotNull(message = "Tweet cannot be null")
    @NotBlank(message = "Tweet cannot be blank")
    private String tweet;


}
