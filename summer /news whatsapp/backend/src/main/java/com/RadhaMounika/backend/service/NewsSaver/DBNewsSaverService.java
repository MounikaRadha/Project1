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
        News newsObj = new News();
        newsObj.setNewsOfToday(news);
        newsRepository.save(newsObj);
        log.info("saved news in db using db news saver service  ...");
    }
}
