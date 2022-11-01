package com.stadtsalat.challenge.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.ResponseEntity;

public interface UrlShortener {

    public ResponseEntity<String> storeUrl(String url);

    public ResponseEntity<String> resolve(String slug);
}
