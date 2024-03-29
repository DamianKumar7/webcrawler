package com.systemdesign.webcrawler.Service;

import com.systemdesign.webcrawler.Entity.CrawlData;
import com.systemdesign.webcrawler.Entity.VisitedUrl;
import com.systemdesign.webcrawler.Repository.CrawlDataRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

@Service
public class WebCrawlerService {
    private final Queue<String> urlQueue = new LinkedList<>();

    @Autowired
    CrawlDataRepository crawlDataRepository;

    @Autowired
    com.systemdesign.webcrawler.Repository.visitedUrlDataRepository visitedUrlDataRepository;
    public void crawlWebsite(String seedUrl){
        urlQueue.add(seedUrl);
        while(!urlQueue.isEmpty()){
            String currentUrl = urlQueue.poll();
             if(!visitedUrlDataRepository.existsByUrl(currentUrl)){
                 try{
                     Document document = Jsoup.connect(currentUrl).get();
                     String webPage = document.outerHtml();

                     crawlDataRepository.save(new CrawlData(currentUrl,webPage));
                     visitedUrlDataRepository.save(new VisitedUrl(currentUrl));
                     Elements links = document.select("a[href]");
                     for(Element link: links){
                         urlQueue.add(link.absUrl("abs:href"));
                     }

                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
        }
    }
}
