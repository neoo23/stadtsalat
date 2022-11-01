package com.stadtsalat.challenge.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UrlShortenerImpl implements UrlShortener {

    // slug->url
    HashMap<String, String> urls = new HashMap<String, String>();

    @Override
    public ResponseEntity<String> storeUrl(String url) {
        if( ! url.equalsIgnoreCase("no-slug"))
            // on 'no-slug' return INTERNAL_SERVER_ERROR ,, for testing

        for(int i=0; i<10 /* paranoia check */ ;) {
            String slug = RandomStringUtils.randomAlphanumeric(5);
            if ( ! urls.containsKey(slug)) {
                urls.put(slug, url);
                return new ResponseEntity<String>(slug, HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>("no slug found error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> resolve(String slug) {
        return new ResponseEntity<String>(urls.get(slug), HttpStatus.OK);
    }
}