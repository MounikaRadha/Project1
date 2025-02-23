package com.m0wn1la.app2.controller;

import com.m0wn1la.app2.config.PrivateURLConstants;
import com.m0wn1la.app2.dto.UserDTO;
import com.m0wn1la.app2.exception.ResourceNotFoundException;
import com.m0wn1la.app2.mapper.UserMapper;
import com.m0wn1la.app2.model.User;
import com.m0wn1la.app2.request.UserCreateRequest;
import com.m0wn1la.app2.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(PrivateURLConstants.USERS)
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @RequestMapping( method = RequestMethod.GET)
    public Page<UserDTO> index() {
        return userService.findAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET,path = "/findById/{id}")
    public UserDTO get(@PathVariable("id") Long id) throws ResourceNotFoundException {
    return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.GET,path ="/findByName/{user_name}")
    public Page<UserDTO> get(@PathVariable("user_name") String userName) {
        return userService.findByUserName(userName);
    }
    @RequestMapping(path = "/create_new", method = RequestMethod.POST)
    public UserDTO createUntitledTestCase(@RequestBody UserCreateRequest request){
        return userService.create(request);

    }
}
