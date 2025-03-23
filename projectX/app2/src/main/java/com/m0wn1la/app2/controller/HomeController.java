package com.m0wn1la.app2.controller;

import com.m0wn1la.app2.security.APIToken;
import com.m0wn1la.app2.security.JWTTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/generate_token")
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HomeController {

    private final JWTTokenService jwtTokenService;
    @RequestMapping
    public String home1() {
        String token=jwtTokenService.generateToken(new APIToken(2));
        return " welcome to the app,token is  " +token;
    }

}
