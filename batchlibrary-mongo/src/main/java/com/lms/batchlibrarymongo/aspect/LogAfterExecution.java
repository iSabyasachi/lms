package com.lms.batchlibrarymongo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogAfterExecution {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@AfterReturning("execution(* com.lms.batchlibrarymongo.*.*.*(..))")
	public void logAfterExecution(JoinPoint joinPoint) {
		logger.info("Method {} complete", joinPoint.getSignature());
	}
	
	@AfterReturning(
            value = "execution(* com.lms.batchlibrarymongo.service.*.*(..))",
            returning = "result")
	public void logAfterExecution(JoinPoint joinPoint, Object result) {
	    logger.info("Method {} returned with: {}", joinPoint, result);
	}
	
	
	@AfterThrowing(
			value = "execution(* com.lms.batchlibrarymongo.*.*.*(..))",
			throwing = "exception")
	public void logAfterException(JoinPoint joinPoint, Object exception) {
	    logger.info("Method {} returned with: {}", joinPoint, exception);
	}
	
	@After(value = "execution(* com.lms.batchlibrarymongo.service.*.*(..))")
	public void logAfterMethod(JoinPoint joinPoint) {
		logger.info("After {}", joinPoint);
	}
}
