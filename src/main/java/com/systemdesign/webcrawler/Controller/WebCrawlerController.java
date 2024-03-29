package com.systemdesign.webcrawler.Controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class WebCrawlerController {

    @PostMapping("/crawl")
    public void crawlWebsite(){

    }
}
