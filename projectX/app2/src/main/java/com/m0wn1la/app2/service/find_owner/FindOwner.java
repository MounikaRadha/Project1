package com.m0wn1la.app2.service.find_owner;

import com.m0wn1la.app2.exception.ResourceNotFoundException;
import com.m0wn1la.app2.model.BaseEntity;

abstract public class FindOwner {
   public abstract  BaseEntity findOwner(Long id) throws ResourceNotFoundException;
}
