package com.RadhaMounika.backend.controller;

import com.RadhaMounika.backend.service.NewsScrapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class Home {
    private final NewsScrapperService newsScrapperService;

    @GetMapping("/home")
    public String home() {
        return "helllllo world";
    }

    @GetMapping("scrape")
    public String scrape() {
        return newsScrapperService.scrapeNews();
    }


}
