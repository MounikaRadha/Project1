package com.m0wn1la.app2.service.find_owner;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Log4j2
public class FindOwnerFactory {
    private final FindPostOwner findPostOwner;
    private final FindEndPointOwner findEndPointOwner;

    public FindOwner getFindOwnerService(String className) {
        if (className.toLowerCase().contains("endpoint")) {
            return findEndPointOwner;
        } else if (className.toLowerCase().contains("post")) {
            return findPostOwner;
        } else {
            return null;
        }
    }

    ;
}
