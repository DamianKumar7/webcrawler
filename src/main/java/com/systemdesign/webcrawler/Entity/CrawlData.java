package com.systemdesign.webcrawler.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "crawl_data")
@Getter
@Setter
@Data
public class CrawlData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url")
    private String url;

    @Column(name = "html")
    private String htmlContent;



    public CrawlData() {
    }

    public CrawlData(String url, String htmlContent) {
        this.url = url;
        this.htmlContent = htmlContent;
    }


}
