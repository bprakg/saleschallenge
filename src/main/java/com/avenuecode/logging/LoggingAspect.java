package com.avenuecode.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static Logger LOGGER = LoggerFactory.getLogger("com.avenuecode.logging.LoggingAspect");

	@Around("com.avenuecode.logging.SystemArchitecture.inWebLayer()")
    public Object loggingAdvice(ProceedingJoinPoint pjp) throws Throwable {
		LOGGER.info("Calling ... "+pjp.getSignature()+"\n");
        Object retVal = pjp.proceed();
		LOGGER.info("Done calling ...\n");
        return retVal;
    }
}
