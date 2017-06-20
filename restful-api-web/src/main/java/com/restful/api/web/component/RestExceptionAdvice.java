package com.restful.api.web.component;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import com.restful.api.core.advice.ExceptionAdvice;

/**
 * 全局异常处理
 * Created by Gaojun.Zhou 2017年6月20日
 */
@ControllerAdvice
@ResponseBody
public class RestExceptionAdvice extends ExceptionAdvice{

}
