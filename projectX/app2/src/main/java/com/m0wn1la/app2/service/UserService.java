package com.m0wn1la.app2.service;

import com.m0wn1la.app2.dto.UserDTO;
import com.m0wn1la.app2.exception.ResourceNotFoundException;
import com.m0wn1la.app2.mapper.UserMapper;
import com.m0wn1la.app2.model.User;
import com.m0wn1la.app2.repository.UserRepository;
import com.m0wn1la.app2.request.UserCreateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Log4j2
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public UserDTO create(UserCreateRequest request) {
        log.debug("creating a new user");
        User user = new User();
        user.setUserName(request.getUsername());
        user=userRepository.save(user);
        log.debug("created a new user with id {}",user.getId());
        return userMapper.userToUserDTO(user);

    }

    public UserDTO getUser(Long id) throws ResourceNotFoundException {
      User user=  userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Couldn't find TestCase resource with id:" + id));
      return userMapper.userToUserDTO(user);
    }

    public Page<UserDTO> findAllUsers() {
        log.debug("finding all users");
        Pageable pageable=Pageable.ofSize(2);
        Page<User> users = userRepository.findAll(pageable);
        return users.map(userMapper::userToUserDTO);
    }
}
