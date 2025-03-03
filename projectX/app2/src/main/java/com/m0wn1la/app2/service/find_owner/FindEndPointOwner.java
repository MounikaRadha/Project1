package com.m0wn1la.app2.service.find_owner;

import com.m0wn1la.app2.exception.ResourceNotFoundException;
import com.m0wn1la.app2.model.BaseEntity;
import com.m0wn1la.app2.service.EndPointService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FindEndPointOwner extends FindOwner {
    private final EndPointService endPointService;

    @Override
    public BaseEntity findOwner(Long id) throws ResourceNotFoundException {
        return endPointService.findOwner(id);
    }
}
