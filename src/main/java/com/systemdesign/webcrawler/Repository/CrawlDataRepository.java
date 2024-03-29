package com.systemdesign.webcrawler.Repository;

import com.systemdesign.webcrawler.Entity.CrawlData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrawlDataRepository  extends JpaRepository<CrawlData,Long> {
}
