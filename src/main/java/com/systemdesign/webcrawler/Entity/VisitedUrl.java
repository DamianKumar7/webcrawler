package com.systemdesign.webcrawler.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "visited_url")
@Data
public class VisitedUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url")
    private String url;



    public VisitedUrl() {
    }

    public VisitedUrl(String url) {
        this.url = url;
    }

}