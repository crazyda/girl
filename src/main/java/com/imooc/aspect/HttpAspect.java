package com.imooc.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.Joinpoint;
import org.apache.log4j.spi.LoggerFactory;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class HttpAspect {
	
	private final static Logger  logger = org.slf4j.LoggerFactory.getLogger(HttpAspect.class);
	
	//需要拦截得入口 方法执行前 先执行得
	@Pointcut("execution(public * com.imooc.controller.GirlController.*(..))")
	public void log(){
		
	}
	@Before("log()")
	public void doBefore( ){
		ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attr.getRequest();
		logger.info("url={}",request.getRequestURL());
		logger.info("method={}",request.getMethod());
		logger.info("ip={}",request.getRemoteAddr());
		//使用joinPoint 获取类名 和类方法?
	
	}
	
	@After("log()")
	public void doAfter(){
		logger.info("2222222");
	}
	@AfterReturning(returning = "object", pointcut="log()")
	public void doAfterReturning(Object object){
		logger.info("response={}",object.toString());
	}
	
	
}
