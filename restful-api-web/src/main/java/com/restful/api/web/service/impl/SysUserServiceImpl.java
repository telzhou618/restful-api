package com.restful.api.web.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.restful.api.web.entity.SysUser;
import com.restful.api.web.mapper.SysUserMapper;
import com.restful.api.web.service.ISysUserService;

/**
 *
 * SysUser 表数据服务层接口实现类
 *
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

	@Override
	public SysUser login(String userName,String password) {
		// TODO Auto-generated method stub
		String pwd = DigestUtils.md5DigestAsHex(password.getBytes());
		return this.selectOne(new EntityWrapper<SysUser>().eq("userName", userName).eq("password", pwd));
	}
}