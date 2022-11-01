package com.stadtsalat.challenge.service;

import com.stadtsalat.challenge.domain.UrlData;
import com.stadtsalat.challenge.domain.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class UrlShortenerImpl implements UrlShortener {

    // slug->url
    HashMap<String, UrlData> urls = new HashMap<String, UrlData>();

    @Override
    public ResponseEntity<UrlData> storeUrl(String url, String slug_, Optional<User> user) {
        String slug = slug_;
        if(!slug.isEmpty()) {
            if(slug.length() <= 10 && slug.length() >= 5) {
                // wished slug
            }
            else {
                // wrong slug size ... INTERNAL_SERVER_ERROR ... for testing
                slug = "";
            }
        }
        else
        for(int i=0; i<10 /* paranoia check */ ; i++) {
            slug = RandomStringUtils.randomAlphanumeric(5);
            if ( ! urls.containsKey(slug)) {
                break;
            } else {
                slug = "";
            }
        }

        if (slug.isEmpty()) {
            return new ResponseEntity<UrlData>(new UrlData("no slug found error", url, user), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        // save slug
        UrlData urlData = new UrlData(slug, url, user);
        urls.put(slug, urlData);
        return new ResponseEntity<UrlData>(urlData, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UrlData> resolve(String slug) {
        return new ResponseEntity<UrlData>(urls.get(slug), HttpStatus.OK);
    }
}