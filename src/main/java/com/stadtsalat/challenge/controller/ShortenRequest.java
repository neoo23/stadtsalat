package com.stadtsalat.challenge.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ShortenRequest {

    private String url;
    private String slug;

}
