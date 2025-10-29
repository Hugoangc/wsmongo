package com.webservices.wsmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.webservices.wsmongo.domain.Post;

import java.time.Instant;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

  @Query("{ 'title': { $regex: ?0, $option: 'i' } }")
  List<Post> searchTitle(String text);

  List<Post> findByTitleContainingIgnoreCase(String text);

  @Query("{ $and: [ { moment: {$gte: ?1} }, { moment: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
  List<Post> fullSearch(String text, Instant minDate, Instant maxDate);

  // localhost:8080/posts/fullsearch?text=Comentario&maxDate=2025-11-30
}