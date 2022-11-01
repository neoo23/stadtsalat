package com.stadtsalat.challenge.controller;

import com.stadtsalat.challenge.service.UrlShortener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlShortenerController {
    private final UrlShortener urlShortener;

    public UrlShortenerController(final UrlShortener urlShortener) {this.urlShortener = urlShortener;}


    @PostMapping("/shorten/")
    public ResponseEntity<String> shortenUrl(@RequestBody ShortenRequest req) {
        return urlShortener.storeUrl(req.getUrl(), req.getSlug());
    }

    @GetMapping("/resolve/{slug}")
    public ResponseEntity<String> resolve(@PathVariable(value = "slug") String slug) {
        return urlShortener.resolve(slug);
    }

}