package com.stadtsalat.challenge.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "URL_DATA")
public class UrlData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String slug;
    private String url;

    @ManyToOne
    private User user;

}
