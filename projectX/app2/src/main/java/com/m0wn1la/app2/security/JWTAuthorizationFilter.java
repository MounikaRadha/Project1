package com.m0wn1la.app2.security;

import com.m0wn1la.app2.context.UserContext;
import com.m0wn1la.app2.exception.InvalidJwtTokenException;
import com.m0wn1la.app2.exception.ResourceNotFoundException;
import com.m0wn1la.app2.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
@Log4j2
@Order(1)
public class JWTAuthorizationFilter extends OncePerRequestFilter {
    private final JWTTokenService jwtTokenService;
    private final UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String header = request.getHeader("Authorization");
            if (header == null) {
                log.info("no authorization header present setting user as 1");
                UserContext.setCurrentUser(userService.getUserById(2L));
            } else {
                APIToken apiToken = jwtTokenService.parseToken(header.substring(7));
                UserContext.setCurrentUser(userService.getUserById(apiToken.getUserId()));
            }
        } catch (ResourceNotFoundException | InvalidJwtTokenException e) {
            throw new RuntimeException(e);
        }
        filterChain.doFilter(request, response);
    }
}
