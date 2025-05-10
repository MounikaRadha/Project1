package com.RadhaMounika.backend.service.NewsSaver;

import com.RadhaMounika.backend.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NewsSaverServiceFactory {

    @Value("${spring.internal.news.saving.way}")
    private String newsSavingMethod;

    private final DBNewsSaverService dbNewsSaverService;
    private final S3NewsSaverService s3NewsSaverService;

    public NewsSaverService getNewsSaverService() {
        if ("s3".equalsIgnoreCase(newsSavingMethod)) {
            return s3NewsSaverService;
        }
        if ("db".equalsIgnoreCase(newsSavingMethod)) {
            return dbNewsSaverService;
        }
        return null; // You may consider throwing an exception here instead
    }
}

