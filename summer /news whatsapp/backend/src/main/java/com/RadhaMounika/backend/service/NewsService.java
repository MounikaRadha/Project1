package com.RadhaMounika.backend.service;

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
        //scrapes news and returns the scraped news as string,saves and shares news
        try {
            log.info("scrapping news ....");
            ProcessBuilder pb = new ProcessBuilder("python3",
                    "//Users//radha.mounika//personalProjects//new//summer //news whatsapp//backend//src//main//java//com//RadhaMounika//backend//python//scrape.py");

            pb.redirectErrorStream(true);
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            int exitCode = process.waitFor();
            String news = output.toString().replace("<br>", "\n");
            if (exitCode == 0) {
                log.info("saving news...");
                saveNews(news);
            }
            return exitCode == 0 ? news : "Error during scraping";

        } catch (Exception e) {
            e.printStackTrace();
            return "Exception occurred: " + e.getMessage();
        }
    }

    public void saveNews(String news) {
        newsSaverServiceFactory.getNewsSaverService().saveNews(news);
    }

    public String getTodayNews() {
        return newsRepository.findTodayNews();
    }
}

