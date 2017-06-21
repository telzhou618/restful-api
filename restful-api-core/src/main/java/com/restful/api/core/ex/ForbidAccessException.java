package com.restful.api.core.ex;

/**
 * 禁止访问异常
 * Created by Gaojun.Zhou 2017年6月8日
 */
public class ForbidAccessException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ForbidAccessException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ForbidAccessException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ForbidAccessException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ForbidAccessException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ForbidAccessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
	
}
