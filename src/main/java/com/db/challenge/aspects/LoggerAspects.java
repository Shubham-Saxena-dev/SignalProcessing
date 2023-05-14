package com.db.challenge.aspects;

import com.db.challenge.model.Signal;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Aspect
public class LoggerAspects {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());


    @Before("execution(* com.db.challenge.services.SignalService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        LOG.info(" Executing method: {}, with params: {}", joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(* com.db.challenge.services.SignalService.*(..)) && args(signal)")
    public void logAfter(JoinPoint joinPoint, Signal signal) {
        LOG.info("Signal: {}, executed successfully.", signal.getSignal());
    }
}
