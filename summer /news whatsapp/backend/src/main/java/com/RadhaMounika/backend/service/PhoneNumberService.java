package com.RadhaMounika.backend.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
@Log4j2
@Service
public class PhoneNumberService {
    public  String addPhoneNumber(String phoneNumber){
       log.info("the phone number is: "+phoneNumber);
       return "phone number added";
    }
}
