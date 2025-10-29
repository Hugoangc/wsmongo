package com.webservices.wsmongo.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webservices.wsmongo.domain.Post;
import com.webservices.wsmongo.repository.PostRepository;
import com.webservices.wsmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

  @Autowired
  private PostRepository repo;

  public Post findById(String id) {
    Optional<Post> Post = repo.findById(id);
    return Post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
  }

  public List<Post> findByTitle(String text) {
    return repo.searchTitle(text);
  }

  public List<Post> fullSearch(String text, Instant minDate, Instant maxDate) {
    maxDate = maxDate.plus(1, ChronoUnit.DAYS);
    return repo.fullSearch(text, minDate, maxDate);
  }

  public Post insert(Post obj) {
    obj.setId(null);
    return repo.save(obj);
  }

  public void delete(String id) {
    findById(id);
    repo.deleteById(id);
  }

  public Post update(Post obj) {
    Post newObj = findById(obj.getId());
    updateData(newObj, obj);
    return repo.save(newObj);
  }

  private void updateData(Post newObj, Post obj) {
    newObj.setTitle(obj.getTitle());
    newObj.setBody(obj.getBody());

  }
}
