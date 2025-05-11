package com.RadhaMounika.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CronService {
    private final EmailAddressService emailAddressService;
    private final NewsService newsService;
    @Scheduled(cron = "${spring.news.cron.time:-}")
    public void scheduledRun(){
        newsService.scrapeAndSaveNews();
        sendEmailsToAllSubscribers();
    }
    public List<String> getSubscribedEmails(){
    return emailAddressService.getUserEmails();
    }
    public void sendEmailsToAllSubscribers(){
        getSubscribedEmails().forEach(emailAddressService::sendNewsToEmailAddress);
    }
}
