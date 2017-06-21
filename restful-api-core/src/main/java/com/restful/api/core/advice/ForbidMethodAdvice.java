package com.restful.api.core.advice;

import java.lang.reflect.Method;

import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.restful.api.core.anno.ForbidMethod;
import com.restful.api.core.ex.ForbidAccessException;
/**
 * 禁止指定方法访问
 * Created by Gaojun.Zhou 2017年6月21日
 */
@Aspect
@Component
public class ForbidMethodAdvice {
	
	public static final Logger logger = Logger.getLogger(ForbidMethodAdvice.class);
	
	@Pointcut("this(com.restful.api.core.controller.CrudController)")
	public void controllerAspect() {
		
	}
	/**
	 * 当方法开始执行之前执行
	 * @param joinPoint
	 */
	@Before("controllerAspect()")
	public void doBefore(JoinPoint joinPoint) {
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		
		String name =  method.getName();	//方法名称
		Object ctr = joinPoint.getTarget(); //当前控制器
		
		logger.debug("methodName : " + name + ", ctr : " + ctr);
		
		ForbidMethod forbidMethodAnno =  joinPoint.getTarget().getClass().getAnnotation(ForbidMethod.class);
		if(forbidMethodAnno!=null){
			String[] value = forbidMethodAnno.value();
			if(ArrayUtils.contains(value, name)){
				throw new ForbidAccessException(ctr.getClass().getSimpleName()+"'"+name + " is Forbid Access.");
			}
		}
		
	}
}
