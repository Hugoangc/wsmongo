package com.webservices.wsmongo.services;

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

}
