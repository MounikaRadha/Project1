package com.example.demo.service;

import com.example.demo.dto.MyRequestBody;
import com.example.demo.modals.UserData;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private final UserRepository userRepository;
    public String saveUser(MyRequestBody userData) {
        UserData user = new UserData();
        user.setBusinessType(userData.getBusinessType());
        user.setTargetAudience(userData.getTargetAudience());
        user.setKeySellingPoints(userData.getKeySellingPoints());
        userRepository.save(user);
        return "successfully saved user";
    }
}
