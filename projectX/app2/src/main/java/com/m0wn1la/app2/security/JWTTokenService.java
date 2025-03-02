package com.m0wn1la.app2.security;

import com.m0wn1la.app2.exception.InvalidCredentialsException;
import com.m0wn1la.app2.exception.ResourceNotFoundException;
import com.m0wn1la.app2.exception.TheUpdaterException;
import com.m0wn1la.app2.model.User;
import com.m0wn1la.app2.service.UserService;
import com.m0wn1la.app2.utils.PasswordHashingUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
@Log4j2
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class JWTTokenService {
    @Value("${jwt.secret}")
    private static String JWT_SECRET;
    private final UserService userService;
    private final PasswordHashingUtil passwordHashingUtil;
    public APIToken parseToken(String token) {
        Claims body = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        String password=body.get("password", String.class);
        Long userId=   body.get("userId", Long.class);
        validateUser(userId, password);
        return new APIToken(userId==null?0:userId);
    }
    public void validateUser(Long userId,String password){
        try {
            User user=userService.getUserById(userId);
            String generatedHash=passwordHashingUtil.hashPassword(password,user.getSalt());
            if(generatedHash.equals(user.getHashedPassword())){
                log.info("hash matched ... valid user");
            }
            else{
                throw  new InvalidCredentialsException("incorrect match of userId,passowrd");
            }
        } catch (TheUpdaterException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public static String generateToken(APIToken apiToken) {
        Claims claims = Jwts.claims().setSubject("token1111");//todo change subject
        claims.put("userId", apiToken.getUserId());
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }
}
