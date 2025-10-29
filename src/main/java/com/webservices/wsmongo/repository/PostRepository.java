package com.webservices.wsmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.webservices.wsmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}