package com.stadtsalat.challenge.service;

import com.stadtsalat.challenge.domain.UrlData;
import com.stadtsalat.challenge.domain.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UrlShortener {

    ResponseEntity<UrlData> storeUrl(String url, String slug, Optional<User> user);

    ResponseEntity<UrlData> resolve(String slug);
}
