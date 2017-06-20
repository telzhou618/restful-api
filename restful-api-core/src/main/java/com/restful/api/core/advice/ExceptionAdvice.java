package com.restful.api.core.advice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.restful.api.core.Rest;
import com.restful.api.core.ex.NotFindDataException;

/**
 * 全局异常处理器
 * Created by Gaojun.Zhou 2017年6月8日
 */
public class ExceptionAdvice {
	
	public static final Logger logger = Logger.getLogger(ExceptionAdvice.class);
	
	  /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public Rest handleValidationException(ValidationException e) {
        logger.error("参数验证失败", e);
        return Rest.failure(400,"参数验证失败",null,e.getMessage());
    }
	 /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Rest handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error("参数解析失败", e);
        return Rest.failure(400,"参数解析失败",null,e.getMessage());
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Rest handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e,HttpServletRequest request) {
        logger.error("不支持当前请求方法", e);
        return Rest.failure(405,String.format("不支持%s请求方式",request.getMethod()),null,e.getMessage());
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Rest handleHttpMediaTypeNotSupportedException(Exception e) {
        logger.error("不支持当前媒体类型", e);
        return Rest.failure(415,"不支持当前媒体类型",null,e.getMessage());
    }

    /**
     * 404 - Not Found
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public Rest handleNoHandlerFoundException(NoHandlerFoundException  e) {
        logger.error("资源不存在", e);
        return Rest.failure(404,"资源不存在",null,e.getMessage());
    }
    
    /**
     * 500 - NullPointerException Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NullPointerException.class)
    public Rest handleNullPointerException(NullPointerException e) {
        logger.error("空指针异常", e);
        return Rest.failure(500,"空指针异常",null,e.getMessage());
    }
    /**
     * 604 - NullPointerException Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NotFindDataException.class)
    public Rest handleNotFindDataException(NotFindDataException e) {
        logger.error("未查到数据", e);
        return Rest.failure(e.getCode(),e.getMessage(),null,e.getClass().getName());
    }
    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Rest handleException(Exception e) {
        logger.error("服务运行异常,"+e.getMessage(), e);
        return Rest.failure(500,e.getMessage(),null,e.getClass().getName());
    }
}
