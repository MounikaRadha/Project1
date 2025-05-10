package com.RadhaMounika.backend.controller;

import com.RadhaMounika.backend.service.EmailAddressService;
import com.RadhaMounika.backend.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class Home {
    private final NewsService newsService;
    private final EmailAddressService emailAddressService;

    @GetMapping("/home")
    public String home() {
        return "helllllo world";
    }

    @GetMapping("scrape")
    public String scrape() {
        //scrapes data using a python script and returns a string of news ,saves,shares via email
        return newsService.scrapeAndSaveNews();
    }

    @GetMapping("addEmailAddress")
    public String addEmailAddress(@RequestParam String emailAddress) {
        //users email address will come here we add it to db if not exists and send email
        return emailAddressService.addEmailAddress(emailAddress);
    }

    @PostMapping("payment")
    public void payment() {
        paymentService.processPayment();
    }


}
