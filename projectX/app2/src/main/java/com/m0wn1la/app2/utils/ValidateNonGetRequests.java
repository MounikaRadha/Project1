package com.m0wn1la.app2.utils;

import com.m0wn1la.app2.context.UserContext;
import com.m0wn1la.app2.exception.CheatingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Log4j2
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ValidateNonGetRequests {
    private final UserContext userContext;

    public void validateNonGetRequests(Long givenUserId) throws CheatingException {
        if (Objects.equals(UserContext.getCurrentUser().getId(), givenUserId)) {
            log.info("given user id is equal to the user who is in context ....:)  ");
        } else {
            throw new CheatingException("you are trying to update/delete someone else's data ......");
        }
    }
}
