package com.restful.api.web.service.impl;

import com.restful.api.web.entity.User;
import com.restful.api.web.mapper.UserMapper;
import com.restful.api.web.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GaoJun.Zhou
 * @since 2017-06-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	
}
