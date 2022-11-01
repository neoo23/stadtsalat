package com.stadtsalat.challenge.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.ResponseEntity;

public interface UrlShortener {

    ResponseEntity<String> storeUrl(String url, String slug);

    ResponseEntity<String> resolve(String slug);
}
