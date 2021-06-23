package com.stadtsalat.challenge.controller;

import com.stadtsalat.challenge.domain.User;
import com.stadtsalat.challenge.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(final UserRepository userRepository) {this.userRepository = userRepository;}

    @GetMapping("/users")
    public List<User> users() {
        return
                StreamSupport.stream(userRepository.findAll().spliterator(), false)
                        .collect(Collectors.toList());
    }
}