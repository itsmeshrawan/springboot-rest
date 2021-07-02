package com.reinforce.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import org.aspectj.lang.reflect.MethodSignature;

@Component
@Aspect
public class ApplicationLogging {

	Logger logger = LoggerFactory.getLogger(ApplicationLogging.class);

	// AOP expression for which methods shall be intercepted
	@Around("execution(* com.reinforce.service..*(..)))")
	public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

		// Get intercepted method details
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();

		final StopWatch stopWatch = new StopWatch();

		// Measure method execution time
		stopWatch.start();
		Object result = proceedingJoinPoint.proceed();
		stopWatch.stop();

		// Log method execution time
		logger.info(
				"Execution time of " + className + "." + methodName + " :: " + stopWatch.getTotalTimeMillis() + " ms");

		return result;
	}

}
