package com.RadhaMounika.backend.service;

import com.RadhaMounika.backend.modals.PhoneNumber;
import com.RadhaMounika.backend.repository.PhoneNumberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PhoneNumberService {
    private final PhoneNumberRepository phoneNumberRepository;
    private final EmailService emailService;

    public String addPhoneNumber(String phoneNumber) {
        log.info("the phone number is: " + phoneNumber);
        if (this.checkPhoneNumberExists(phoneNumber)) {
            return "phone number already exists";
        }
        PhoneNumber phoneNumber1 = new PhoneNumber();
        phoneNumber1.setUserPhoneNumber(phoneNumber);
        phoneNumberRepository.save(phoneNumber1);
        emailService.sendEmail(phoneNumber,"dummy body");
        return "phone number added";
    }

    public boolean checkPhoneNumberExists(String phoneNumber) {
        log.info("the phone number is: " + phoneNumber);
        PhoneNumber PhoneNumber;
        return phoneNumberRepository.existsPhoneNumberByUserPhoneNumber(phoneNumber);
    }
}
