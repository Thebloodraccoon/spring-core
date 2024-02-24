package org.hillel.spring.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Pointcut("execution(* org.hillel.spring.service..*.*(..))")
    private void serviceMethod() {}

    @Pointcut("execution(* org.hillel.spring.repo..*.*(..))")
    private void repoMethod() {}

    @Pointcut("execution(* org.hillel.spring.controller..*.*(..))")
    private void controllerMethod() {}

    @Around(value = "serviceMethod() || repoMethod() || controllerMethod()")
    public Object logAroundMethod(ProceedingJoinPoint pjp) throws Throwable{
        final Signature signature = pjp.getSignature();
        log.debug("Calling {} with args: {}", signature, Arrays.toString(pjp.getArgs()));

        final Object result = pjp.proceed();

        log.debug("Method {} returned {}", pjp.getSignature(), result);

        return result;
    }

    @AfterThrowing(value = "serviceMethod() || repoMethod()", throwing = "e")
    public void logMethodAfterThrown(Exception e) {
        log.error("Exception in service method: {}", e.getMessage());
    }
}
