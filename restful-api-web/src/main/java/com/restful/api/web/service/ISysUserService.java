package com.restful.api.web.service;

import com.baomidou.mybatisplus.service.IService;
import com.restful.api.web.entity.SysUser;

/**
 *
 * SysUser 表数据服务层接口
 *
 */
public interface ISysUserService extends IService<SysUser> {
	
	/**
	 * 登录
	 */
	SysUser login(String userName,String password);

}