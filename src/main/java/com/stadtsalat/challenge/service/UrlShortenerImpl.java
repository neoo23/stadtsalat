package com.stadtsalat.challenge.service;

import com.stadtsalat.challenge.domain.UrlData;
import com.stadtsalat.challenge.domain.User;
import com.stadtsalat.challenge.repository.UrlDataRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UrlShortenerImpl implements UrlShortener {

    private final UrlDataRepository urlDataRepository;

    // slug->url cache
    HashMap<String, UrlData> urls = new HashMap<String, UrlData>();

    public UrlShortenerImpl(UrlDataRepository urlDataRepository) {
        this.urlDataRepository = urlDataRepository;
    }

    @PostConstruct
    void loadUrls() {
        this.urlDataRepository.findAll().forEach(u -> urls.put(u.getSlug(), u));
    }

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
            return new ResponseEntity<UrlData>(new UrlData(null, "no slug found error", url, null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        // save urlData
        UrlData urlData = new UrlData(null, slug, url, user.orElse(null));
        urlDataRepository.save(urlData);
        // save slug
        urls.put(slug, urlData);
        return new ResponseEntity<UrlData>(urlData, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UrlData> resolve(String slug) {
        return new ResponseEntity<UrlData>(urls.get(slug), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UrlData>> deleteByLastName(String lastName) {
        if(lastName.isEmpty()) {
            return new ResponseEntity(Collections.emptyList(), HttpStatus.OK);
        }
        List<UrlData> toDelete = urls.values().stream()
                .filter(u -> lastName.equalsIgnoreCase(u.getUser() != null ? u.getUser().getLastName() : ""))
                .collect(Collectors.toList());
        toDelete.forEach(u -> urls.remove(u.getSlug()));
        return new ResponseEntity(toDelete, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UrlData>> urls() {
        return new ResponseEntity(urls.values(), HttpStatus.OK);
    }


}