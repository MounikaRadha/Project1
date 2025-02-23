package com.m0wn1la.app2.service;

import com.m0wn1la.app2.model.User;
import com.m0wn1la.app2.repository.UserRepository;
import com.m0wn1la.app2.request.UserCreateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Log4j2
public class UserService {
    private final UserRepository userRepository;
    public User create(UserCreateRequest request) {
        log.debug("creating a new user");
        User user = new User();
        user.setUserName(request.getUsername());
        user=userRepository.save(user);
        log.debug("created a new user with id {}",user.getId());
        return user;
    }
}
