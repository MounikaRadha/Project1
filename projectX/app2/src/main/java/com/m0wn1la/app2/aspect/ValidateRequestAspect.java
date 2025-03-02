package com.m0wn1la.app2.aspect;

import com.m0wn1la.app2.Enums.UserInfoLocation;
import com.m0wn1la.app2.utils.ValidateNonGetRequests;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import com.m0wn1la.app2.annotation.ValidateRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ValidateRequestAspect {
    private final ValidateNonGetRequests validateNonGetRequests;
    @Around("@annotation(com.m0wn1la.app2.annotation.ValidateRequest)")
    public Object validateRequest(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        ValidateRequest annotation = methodSignature.getMethod().getAnnotation(com.m0wn1la.app2.annotation.ValidateRequest.class);
        UserInfoLocation category=annotation.category();
        Object[] args = joinPoint.getArgs();
        int positionToValidate=Integer.parseInt(annotation.positionToValidate());
        if(category==UserInfoLocation.CONTROLLER_PATH){
           Long userId=(Long)args[positionToValidate];
           validateNonGetRequests.validateNonGetRequests(userId);
        }
        if(category==UserInfoLocation.METHOD_ARGUMENTS){
            Object object=args[positionToValidate];
            Long userId = (Long) object.getClass().getDeclaredMethod("getUserId").invoke(object);
            validateNonGetRequests.validateNonGetRequests(userId);
        }
        log.info("Validating request...");
        return joinPoint.proceed();
    }
}
