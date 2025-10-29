package com.webservices.wsmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.webservices.wsmongo.domain.User;
import com.webservices.wsmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Override
  public void run(String... args) throws Exception {

    userRepository.deleteAll();

    User sophia = new User(null, "Sophia White", "sowhid@gmail.com");
    User fiorentina = new User(null, "Fiorentina Angelis", "fifiangel@gmail.com");
    User marry = new User(null, "Marry Sun", "sunnyma@gmail.com");

    userRepository.saveAll(Arrays.asList(sophia, fiorentina, marry));
  }

}
