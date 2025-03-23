package com.m0wn1la.app2.service;

import com.m0wn1la.app2.config.DefaultValues;
import com.m0wn1la.app2.dto.UserDTO;
import com.m0wn1la.app2.exception.DuplicateEntryException;
import com.m0wn1la.app2.exception.ResourceNotFoundException;
import com.m0wn1la.app2.mapper.UserMapper;
import com.m0wn1la.app2.model.User;
import com.m0wn1la.app2.repository.UserRepository;
import com.m0wn1la.app2.request.UserPostRequest;
import com.m0wn1la.app2.security.APIToken;
import com.m0wn1la.app2.security.JWTTokenService;
import com.m0wn1la.app2.specification.UserSpecification;
import com.m0wn1la.app2.utils.PasswordHashingUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Log4j2
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordHashingUtil passwordHashingUtil;
    private final JWTTokenService jwtTokenService;

    public UserDTO handlePostRequest(UserPostRequest request) throws DuplicateEntryException {
        if(!isRegister(request)) {
            //user is trying to login ,we have id,passowrd
            return verifyAndSendJWTToken(request);
        }
        Integer userExists=userRepository.checkUserExistence(request.getUsername());
        if(userExists>0) {
            verifyAndSendJWTToken(request);
            String msg=String.format("user with"+request.getUsername()+" name already exists");
            throw new DuplicateEntryException(msg,"User ","username",request.getUsername());
        }
        return  create(request);
    }
    public UserDTO verifyAndSendJWTToken(UserPostRequest request){
        //to register/login there is one single form
        //to register user would give username,password
        //to login user would give id,password

        Long userId=Long.valueOf(request.getUsername());
        jwtTokenService.validateUser(userId,request.getPassword());
        String token=jwtTokenService.generateToken(new APIToken(userId));
        UserDTO userDTO=new UserDTO();
        userDTO.setId(userId);
        userDTO.setUsername("token:"+token);
        return userDTO;
    }

    public Boolean isRegister(UserPostRequest request){
        try{
            Long.parseLong(request.getUsername());
            return false;
        }
        catch (Exception e) {
            return  true;
        }
    }
    public UserDTO create(UserPostRequest request) throws DuplicateEntryException {

        log.debug("creating a new user");
        User user = new User();
        user.setUserName(request.getUsername());
        String salt = passwordHashingUtil.generateSalt();
        String hashedPassword = passwordHashingUtil.hashPassword(request.getPassword(), salt);
        user.setHashedPassword(hashedPassword);
        user.setSalt(salt);
        user = userRepository.save(user);
        log.debug("created a new user with id {}", user.getId());
        return userMapper.userToUserDTO(user);

    }

    public User getUserById(Long id) throws ResourceNotFoundException {
        return userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Couldn't find user resource with id:" + id));

    }

    public Page<UserDTO> findAllUsers(int pageNumber, int pageSize) {
        log.debug("finding all users");
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<User> users = userRepository.findAll(pageable);
        Page<UserDTO> users1 = users.map(user -> userMapper.userToUserDTO(user));
        return users1;
    }

    public Page<UserDTO> findByUserName(String userName) {
        Pageable pageable = Pageable.ofSize(DefaultValues.DEFAULT_PAGE_SIZE);
        Page<User> users = userRepository.findAll(UserSpecification.findByUsername(userName), pageable);
        return users.map(userMapper::userToUserDTO);
    }

    public UserDTO updateUser(Long userId, UserPostRequest request) throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("Could not find user with id: " + userId)
        );
        userMapper.mergeUserPostRequestToUser(request, user);
        userRepository.save(user);
        return userMapper.userToUserDTO(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
