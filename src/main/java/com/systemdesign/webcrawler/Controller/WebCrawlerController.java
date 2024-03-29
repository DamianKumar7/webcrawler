package com.systemdesign.webcrawler.Controller;


import com.systemdesign.webcrawler.Service.WebCrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class WebCrawlerController {

    @Autowired
    WebCrawlerService webCrawlerService;

    @PostMapping("/crawl")
    public void crawlWebsite(@RequestBody String seedUrl){
        webCrawlerService.crawlWebsite(seedUrl);
    }
}
