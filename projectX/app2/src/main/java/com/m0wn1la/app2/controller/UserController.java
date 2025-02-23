package com.m0wn1la.app2.controller;

import com.m0wn1la.app2.config.PrivateURLConstants;
import com.m0wn1la.app2.dto.UserDTO;
import com.m0wn1la.app2.mapper.UserMapper;
import com.m0wn1la.app2.model.User;
import com.m0wn1la.app2.request.UserCreateRequest;
import com.m0wn1la.app2.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(PrivateURLConstants.USERS)
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @RequestMapping( method = RequestMethod.GET)
    public String index() {
        return "Hello World123456!";
    }
    @RequestMapping(path = "/create_new", method = RequestMethod.POST)
    public UserDTO createUntitledTestCase(@RequestBody UserCreateRequest request){
         User user=userService.create(request);
         return userMapper.userToUserDTO(user);

    }
}
