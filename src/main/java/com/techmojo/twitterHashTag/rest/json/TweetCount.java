package com.techmojo.twitterHashTag.rest.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class TweetCount {

    public int frequency;

    public String tag;
}
