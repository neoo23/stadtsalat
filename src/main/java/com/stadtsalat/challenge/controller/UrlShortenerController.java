package com.stadtsalat.challenge.controller;

import com.stadtsalat.challenge.service.UrlShortener;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlShortenerController {
    private final UrlShortener urlShortener;

    public UrlShortenerController(final UrlShortener urlShortener) {this.urlShortener = urlShortener;}


    @PostMapping("/shorten/")
    public String shortenUrl(@RequestBody ShortenRequest request) {
        return urlShortener.storeUrl(request.getUrl());
    }

    @GetMapping("/resolve/{slug}")
    public String resolve(@PathVariable(value = "slug") String slug) {
        return urlShortener.resolve(slug);
    }

}