package com.RadhaMounika.backend.controller;

import com.RadhaMounika.backend.service.NewsScrapperService;
import com.RadhaMounika.backend.service.PhoneNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class Home {
    private final NewsScrapperService newsScrapperService;
    private final PhoneNumberService phoneNumberService;

    @GetMapping("/home")
    public String home() {
        return "helllllo world";
    }

    @GetMapping("scrape")
    public String scrape() {
        //scrapes data using a python script and returns a string of news
        return newsScrapperService.scrapeNews();
    }

    @GetMapping("addPhoneNumber")
    public String addPhoneNumber(@RequestParam String phoneNumber) {
        return phoneNumberService.addPhoneNumber(phoneNumber);
    }


}
