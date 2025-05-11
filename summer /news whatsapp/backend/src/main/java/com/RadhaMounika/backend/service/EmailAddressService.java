package com.RadhaMounika.backend.service;

import com.RadhaMounika.backend.modals.User;
import com.RadhaMounika.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmailAddressService {
    private final UserRepository userRepository;
    private final SmtpEmailService smtpEmailService;
    private final NewsService newsService;

    public String addEmailAddress(String userEmailAddress) {
        //add non existing email address to db
        //send email
        log.info("trying to add email address {} to db ", userEmailAddress);
        if (this.checkEmailAddressAlreadyExists(userEmailAddress)) {
            return " email address  already exists";
        }
        User user = new User();
        user.setUserEmailAddress(userEmailAddress);
        userRepository.save(user);
        log.info("email address {} added to db ", userEmailAddress);
        sendNewsToEmailAddress(userEmailAddress);
        return "email address added and news sent successfully";
    }

    public boolean checkEmailAddressAlreadyExists(String emailAddress) {
        log.info("the email address is: {}", emailAddress);
        return userRepository.existsUserByUserEmailAddress(emailAddress);
    }

    public List<String> getUserEmails(){
        List<User> users= userRepository.findAll();
       return users.stream().map(User::getUserEmailAddress).toList();
    }

    public void sendNewsToEmailAddress(String emailAddress) {
        log.info("trying to send news to email address {}  ", emailAddress);
        smtpEmailService.sendEmail(emailAddress, newsService.getTodayNews());
    }
}
