package com.example.demo.controllers;

import com.example.demo.dto.MyRequestBody;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/home")
@Log4j2
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Home {
    private final UserService userService;
    @GetMapping("/test")
    public String test() {
        return "Hello World";
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/saveData")
    public String saveData(@RequestBody MyRequestBody requestBody) {
        userService.saveUser(requestBody);
        return "Hello World";
    }
}
