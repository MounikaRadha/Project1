package com.RadhaMounika.backend.service;
import java.io.File;
import java.nio.file.Paths;
import com.RadhaMounika.backend.repository.NewsRepository;
import com.RadhaMounika.backend.service.NewsSaver.NewsSaverServiceFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Log4j2
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NewsService {
    private final NewsSaverServiceFactory newsSaverServiceFactory;
    private final NewsRepository newsRepository;

    public String scrapeAndSaveNews() {
        String news = "";
        //scrapes news and returns the scraped news as string,saves and shares news
        try {
            log.info("scrapping news ....");
           File fileObj=new File("./scrape.py");
            log.info("Running script at: " + fileObj.getAbsolutePath());

            ProcessBuilder pb = new ProcessBuilder("python3", fileObj.getAbsolutePath());

            pb.redirectErrorStream(true);
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            log.info("output.string is {}and wait for process", output);
            int exitCode = process.waitFor();
            news = output.toString().replace("<br>", "\n");
            log.info("Exit code: {}news is {}", exitCode, news);
            if (exitCode == 0) {
                log.info("saving news...");
                saveNews(news);
            }
            return exitCode == 0 ? news : "Error during scraping";

        } catch (Exception e) {
            e.printStackTrace();
            return "Exception occurred: " + e.getMessage()+news;
        }
    }

    public void saveNews(String news) {
        newsSaverServiceFactory.getNewsSaverService().saveNews(news);
    }

    public String getTodayNews() {
        return newsRepository.findTodayNews();
    }
}

