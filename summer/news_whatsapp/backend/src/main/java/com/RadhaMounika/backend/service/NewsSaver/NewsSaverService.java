package com.RadhaMounika.backend.service.NewsSaver;

public interface NewsSaverService {
    //it is a high level class
    //in application.properties we set the way of saving method
    //in db or in s3 bucket
    //the factory will give the corresponding bean to the calling method
    void saveNews(String news);
}
