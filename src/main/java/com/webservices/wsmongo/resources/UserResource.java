package com.webservices.wsmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.wsmongo.domain.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    User mario = new User("1", "Mario Cirqueira", "mcirq@gmail.com");
    User fiorentina = new User("2", "Fiorentina Angelis", "fifiangel@gmail.com");
    List<User> list = new ArrayList<>();
    list.addAll(Arrays.asList(mario, fiorentina));
    return ResponseEntity.ok().body(list);
  }

}
