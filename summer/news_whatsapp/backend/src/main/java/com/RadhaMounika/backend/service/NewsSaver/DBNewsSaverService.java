package com.RadhaMounika.backend.service.NewsSaver;

import com.RadhaMounika.backend.modals.News;
import com.RadhaMounika.backend.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DBNewsSaverService implements NewsSaverService {
    private final NewsRepository newsRepository;

    @Override
    public void saveNews(String news) {
        log.info("saving news in db using db news saver service   ...");
        Integer count = newsRepository.findCount();
        log.info("checking the count {}", count);
        if (count > 0) {
            log.info("news object already exists");

            News existingNews = newsRepository.findAll().getFirst();
            existingNews.setNewsOfToday(news);
            newsRepository.save(existingNews);
            return;
        }
        log.info("news object is empty so creating new one");
        News newsObj = new News();
        newsObj.setNewsOfToday(news);
        newsRepository.save(newsObj);
        log.info("saved news in db using db news saver service  ...");
    }
}
