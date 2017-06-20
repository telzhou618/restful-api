package com.restful.api.core.log;

import java.lang.reflect.Method;
import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restful.api.core.anno.Log;
/**
 * 正常业务日志记录
 * @author Administrator
 *
 */
@Aspect
@Component
public class LogAdvice {
	
	public static final Logger logger = Logger.getLogger(LogAdvice.class);
	
	/**
	 * 注入日志记录接口,若存在则记录日志，不存在就忽略
	 */
	@Autowired(required=false) LogApi logApi;
	
	@Pointcut("@annotation(com.restful.api.core.anno.Log)")
	public void controllerAspect() {
		
	}
	/**
	 * 当方法正常返回是执行
	 * @param joinPoint
	 */
	@AfterReturning("controllerAspect()")
	public void doBefore(JoinPoint joinPoint) {
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		Log log =  method.getAnnotation(Log.class);
		if(log != null){
			String logContent = log.value();
			logger.info(String.format("log : [%s]",logContent));
			
			if(logApi != null){
				LogBean logBean = new LogBean();
				logBean.setLogTime(new Date());
				logBean.setLogContent(logContent);
				logApi.log(logBean);
			}else{
				logger.warn("LogApi not finish.");
			}
		}
	}
}
