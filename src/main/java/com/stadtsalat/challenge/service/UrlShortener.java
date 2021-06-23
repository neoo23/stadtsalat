package com.stadtsalat.challenge.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UrlShortener {
    HashMap urls = new HashMap();

    public String storeUrl(String url) {
        String shortUrl = "";
        do {
            shortUrl = RandomStringUtils.randomAlphanumeric(5);
        } while (urls.containsKey(shortUrl));

        urls.put(shortUrl, url);
        return shortUrl;
    }

    public String resolve(String slug) {
        return (String) urls.get(slug);
    }
}