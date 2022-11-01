package com.stadtsalat.challenge.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class UrlData {

    private String slug;
    private String url;
    private Optional<User> user;

}
