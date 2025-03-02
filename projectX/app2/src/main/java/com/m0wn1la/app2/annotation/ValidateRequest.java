package com.m0wn1la.app2.annotation;

import com.m0wn1la.app2.Enums.UserInfoLocation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateRequest {
    UserInfoLocation category() default UserInfoLocation.CONTROLLER_PATH;
    String positionToValidate() default "1";
}
