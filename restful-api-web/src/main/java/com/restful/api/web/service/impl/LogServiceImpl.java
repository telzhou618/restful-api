package com.restful.api.web.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restful.api.core.log.LogApi;
import com.restful.api.core.log.LogBean;

/**
 * 记录日志业务,开发这个实现LogApi接口的log方法可灵活处理日志，如记录在数据库
 * Created by Gaojun.Zhou 2017年6月20日
 */
@Service
public class LogServiceImpl implements LogApi {

	public static final Logger logger = Logger.getLogger(LogServiceImpl.class);

	@Transactional
	@Override
	public void log(LogBean log) {
		// TODO Auto-generated method stub
		
		//这里实现记录日志的逻辑
		
		//logger.warn("logAdvice not finish,"+log.toString());
	}
	
}