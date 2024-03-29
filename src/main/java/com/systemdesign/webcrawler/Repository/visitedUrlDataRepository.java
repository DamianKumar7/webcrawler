package com.systemdesign.webcrawler.Repository;

import com.systemdesign.webcrawler.Entity.VisitedUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface visitedUrlDataRepository extends JpaRepository<VisitedUrl,Long> {
    boolean existsByUrl(String url);
}
