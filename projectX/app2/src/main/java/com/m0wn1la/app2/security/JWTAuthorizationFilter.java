package com.m0wn1la.app2.security;

import com.m0wn1la.app2.context.UserContext;
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
            String authHeader = request.getHeader("Authorization");
            String userId = request.getHeader("php-auth-user");
            String password = request.getHeader("php-auth-password");
            if (authHeader != null) {
                APIToken apiToken = jwtTokenService.parseToken(authHeader.substring(7));
                UserContext.setCurrentUser(userService.getUserById(apiToken.getUserId()));
            } else if (userId != null && password != null) {
                jwtTokenService.validateUser(Long.valueOf(userId), password);
                UserContext.setCurrentUser(userService.getUserById(Long.valueOf(userId)));
            } else {
                log.info("no authorization authHeader present setting user as 1");
                UserContext.setCurrentUser(userService.getUserById(2L));
            }
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }


}
