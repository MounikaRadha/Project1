package com.m0wn1la.app2.controller;

import com.m0wn1la.app2.config.DefaultValues;
import com.m0wn1la.app2.config.PrivateURLConstants;
import com.m0wn1la.app2.dto.UserDTO;
import com.m0wn1la.app2.exception.ResourceNotFoundException;
import com.m0wn1la.app2.request.UserPostRequest;
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

    @RequestMapping(method = RequestMethod.POST ,path = "/create_new")
    public UserDTO createUntitledTestCase(@RequestBody UserPostRequest request) {
        return userService.create(request);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<UserDTO> index(@RequestParam(name = "page",required = false,defaultValue = "0") int pageNumber,
                               @RequestParam(name = "size",required = false,defaultValue = "2") int pageSize) {
        return userService.findAllUsers(pageNumber,pageSize);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public UserDTO getById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return userService.getUserById(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/findByName/{user_name}")
    public Page<UserDTO> getByUserName(@PathVariable("user_name") String userName) {
        return userService.findByUserName(userName);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public UserDTO updateUserById(@PathVariable("id") Long userId, @RequestBody UserPostRequest request) throws ResourceNotFoundException {
        return userService.updateUser(userId, request);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void deleteUserById(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
    }

}
