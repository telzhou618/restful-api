package com.restful.api.core.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * 验证工具类
 * Created by Gaojun.Zhou 2017年6月22日
 */
public class ValidateUtil {

	public static Map<String, Object> toStringJson(BindingResult result){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		for(FieldError fieldError : result.getFieldErrors()){
			map.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		return map;
		
	}
	
}
