package com.RadhaMounika.backend.service.NewsSaver;

import com.RadhaMounika.backend.modals.News;
import com.RadhaMounika.backend.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DBNewsSaverService implements NewsSaverService {
    private final NewsRepository newsRepository;

    @Override
    public void saveNews(String news) {
        News newsObj = new News();
        newsObj.setNewsOfToday(news);
        newsRepository.save(newsObj);
    }
}
