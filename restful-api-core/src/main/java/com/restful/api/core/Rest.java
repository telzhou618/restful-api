package com.restful.api.core;

/**
 * 相应消息对象
 * Created by Gaojun.Zhou 2017年6月8日
 */

public class Rest {
	
	private int code;
	
	private boolean success;
	
	private String message;
	
	private Object data;
	
	private String details;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Rest(int code, boolean success, String message, Object data, String details) {
		super();
		this.code = code;
		this.success = success;
		this.message = message;
		this.data = data;
		this.details = details;
	}
	
	public static Rest ok(){
		return new Rest(200,true,"ok",null,null);
	}
	
	public static Rest ok(String message){
		return new Rest(200,true,message,null,null);
	}
	
	public static Rest okData(Object object){
		return new Rest(200,true,"ok",object,null);
	}
	
	public static Rest failure(String message){
		return new Rest(500,false,message,null,null);
	}
	
	public static Rest failure(int code,String message,Object object,String details){
		return new Rest(code,false,message,object,details);
	}
	
}
