package com.webservices.wsmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.webservices.wsmongo.domain.Post;
import com.webservices.wsmongo.domain.User;
import com.webservices.wsmongo.repository.PostRepository;
import com.webservices.wsmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Override
  public void run(String... args) throws Exception {

    userRepository.deleteAll();
    postRepository.deleteAll();

    User sophia = new User(null, "Sophia White", "sowhid@gmail.com");
    User fiorentina = new User(null, "Fiorentina Angelis", "fifiangel@gmail.com");
    User marry = new User(null, "Marry Sun", "sunnyma@gmail.com");

    Post post1 = new Post(null, Instant.parse("2025-11-21T03:42:10Z"), "Teste de mensagem", "Conteudo da mensagem",
        marry);
    Post post2 = new Post(null, Instant.parse("2025-11-21T04:42:10Z"), "Teste de mensagem", "Conteudo da mensagem",
        marry);

    userRepository.saveAll(Arrays.asList(sophia, fiorentina, marry));
    postRepository.saveAll(Arrays.asList(post1, post2));
  }

}
