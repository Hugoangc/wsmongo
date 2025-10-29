package com.webservices.wsmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.webservices.wsmongo.domain.Post;
import com.webservices.wsmongo.domain.User;
import com.webservices.wsmongo.dto.AuthorDTO;
import com.webservices.wsmongo.dto.CommentDTO;
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

        userRepository.saveAll(Arrays.asList(sophia, fiorentina, marry));

        Post post1 = new Post(null, Instant.parse("2025-10-21T03:42:10Z"), "Lorem ipsum dolor sit amet",
                "Proin interdum arcu sit amet mauris condimentum pulvinar.",
                new AuthorDTO(marry));
        Post post2 = new Post(null, Instant.parse("2025-10-29T04:42:10Z"), "lorem ipsum dolor sit amet consectetur",
                "Donec feugiat dapibus vestibulum. Nunc elementum ornare felis, non venenatis dolor rhoncus sed.",
                new AuthorDTO(marry));

        CommentDTO c1 = new CommentDTO("Vi que está praticando SPRING", Instant.parse("2025-11-21T04:42:10Z"),
                new AuthorDTO(fiorentina));

        CommentDTO c2 = new CommentDTO("Sim, estou querendo um estágio", Instant.parse("2025-11-25T07:42:10Z"),
                new AuthorDTO(sophia));

        CommentDTO c3 = new CommentDTO("Está triste a vida mesmo", Instant.parse("2025-11-24T07:42:10Z"),
                new AuthorDTO(fiorentina));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));
        postRepository.saveAll(Arrays.asList(post1, post2));
        marry.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(marry);
    }

}
