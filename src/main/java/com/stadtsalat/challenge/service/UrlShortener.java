package com.stadtsalat.challenge.service;

import com.stadtsalat.challenge.domain.UrlData;
import com.stadtsalat.challenge.domain.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UrlShortener {

    /**
     * store an url
     *
     * @param url
     * @param slug
     * @param user
     * @return
     */
    ResponseEntity<UrlData> storeUrl(String url, String slug, Optional<User> user);

    /**
     *
     * @param slug
     * @return url identified by slug
     */
    ResponseEntity<UrlData> resolve(String slug);

    /**
     *
     * @param lastName
     * @return delete all urls of user identified by lastName
     */
    ResponseEntity<List<UrlData>> deleteByLastName(String lastName);

    /**
     *
     * @return all urls
     */
    ResponseEntity<List<UrlData>> urls();
}
