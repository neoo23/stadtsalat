package com.stadtsalat.challenge.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UrlShortenerImpl implements UrlShortener {

    // slug->url
    HashMap<String, String> urls = new HashMap<String, String>();

    @Override
    public String storeUrl(String url) {
        String slug = "";
        do {
            slug = RandomStringUtils.randomAlphanumeric(5);
        } while (!urls.containsKey(slug));
        urls.put(slug, url);
        return slug;
    }

    @Override
    public String resolve(String slug) {
        return (String) urls.get(slug);
    }
}