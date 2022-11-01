package com.stadtsalat.challenge.controller;

import com.stadtsalat.challenge.domain.UrlData;
import com.stadtsalat.challenge.domain.User;
import com.stadtsalat.challenge.repository.UserRepository;
import com.stadtsalat.challenge.service.UrlShortener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UrlShortenerController {
    private final UrlShortener urlShortener;
    private final UserRepository userRepository;

    public UrlShortenerController(final UrlShortener urlShortener, final UserRepository userRepository) {
        this.urlShortener = urlShortener;
        this.userRepository = userRepository;
    }


    @PostMapping("/shorten/")
    public ResponseEntity<UrlData> shortenUrl(@RequestBody ShortenRequest req) {
        Optional<User> user = userRepository.findSingleByLastName(req.getLastName());
        return urlShortener.storeUrl(req.getUrl(), req.getSlug(), user);
    }

    @GetMapping("/resolve/{slug}")
    public ResponseEntity<UrlData> resolve(@PathVariable(value = "slug") String slug) {
        return urlShortener.resolve(slug);
    }

}