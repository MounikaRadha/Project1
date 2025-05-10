package com.RadhaMounika.backend.service;

import com.RadhaMounika.backend.modals.User;
import com.RadhaMounika.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmailAddressService {
    private final UserRepository userRepository;
    private final SmtpEmailService smtpEmailService;

    public String addEmailAddress(String userEmailAddress) {
        //add non existing email address to db
        //send email
        log.info("the email address is: " + userEmailAddress);
        if (this.checkEmailAddressAlreadyExists(userEmailAddress)) {
            return " email address  already exists";
        }
        User user = new User();
        user.setUserEmailAddress(userEmailAddress);
        userRepository.save(user);
        smtpEmailService.sendEmail(userEmailAddress,"dummy body");
        return "email address added";
    }

    public boolean checkEmailAddressAlreadyExists(String emailAddress) {
        log.info("thee email address is: " + emailAddress);
        return userRepository.existsUserByUserEmailAddress(emailAddress);
    }
}
