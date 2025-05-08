package com.RadhaMounika.backend.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class NewsScrapperService {
    public String scrapeNews() {
        try {
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
            return exitCode == 0 ? output.toString().replace("\n", "<br>") : "Error during scraping";

        } catch (Exception e) {
            e.printStackTrace();
            return "Exception occurred: " + e.getMessage();
        }
    }
}

