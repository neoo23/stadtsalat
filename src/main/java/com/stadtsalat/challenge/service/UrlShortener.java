package com.stadtsalat.challenge.service;

import org.apache.commons.lang3.RandomStringUtils;

public interface UrlShortener {

    public String storeUrl(String url);

    public String resolve(String slug);
}
