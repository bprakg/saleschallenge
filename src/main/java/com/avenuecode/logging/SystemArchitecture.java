package com.avenuecode.logging;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemArchitecture {

	@Pointcut("execution(* com.avenuecode.sales.controller.*.*(..))")
	public void inWebLayer() {
	}

	@Pointcut("within(com.avenuecode.sales.service..*)")
	public void inServiceLayer() {
	}
}
