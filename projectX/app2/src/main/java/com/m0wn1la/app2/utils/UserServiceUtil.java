package com.m0wn1la.app2.utils;

import com.m0wn1la.app2.exception.ResourceNotFoundException;
import com.m0wn1la.app2.model.User;
import com.m0wn1la.app2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceUtil {
    private final UserRepository userRepository;
    public User getUserById(Long id) throws ResourceNotFoundException {
        return userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Couldn't find user resource with id:" + id));

    }
}
