package com.techmojo.twitterHashTag.repository;

import com.techmojo.twitterHashTag.model.TweetDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetDetailsRepository extends JpaRepository<TweetDetails, String> {


}
