package com.revature;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Before("execution(* com.revature.*.*(..))")
	public void before(JoinPoint joinPoint){
		
		logger.info("executed: {}", joinPoint);
	}

	@AfterThrowing(pointcut = "execution(* com.revature.*.*(..))", throwing = "t")
	public void exceptionCatch(JoinPoint jp, Throwable t) {
		logger.error("{} threw exception {}", jp, t);
	}
}
