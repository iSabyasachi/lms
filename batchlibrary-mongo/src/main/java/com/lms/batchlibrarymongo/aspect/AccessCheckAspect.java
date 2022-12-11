package com.lms.batchlibrarymongo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AccessCheckAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* com.lms.batchlibrarymongo.service.*.*(..))")
	public void before(JoinPoint joinpoint) {
		logger.info("Intercepted call before execution of: {}", joinpoint);
	}
	
}
