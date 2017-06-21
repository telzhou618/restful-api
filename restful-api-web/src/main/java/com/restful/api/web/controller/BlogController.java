package com.restful.api.web.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.restful.api.core.Rest;
import com.restful.api.core.anno.ForbidMethod;
import com.restful.api.core.controller.AppController;
import com.restful.api.web.entity.Blog;
import com.restful.api.web.service.IBlogService;
/**
 * 标准的Rest接口,实例控制器
 * Created by Gaojun.Zhou 2017年6月8日
 */
@RestController
@RequestMapping("/blog")
@ForbidMethod({"delete"}) //禁止客户端调用add方法
public class BlogController extends AppController<Blog,IBlogService>{  
	
	/**
	 * 分页多表连接查询博客
	 */
    @GetMapping("/findJoinPage")  
    public  Rest findJoinPage(@RequestParam (required = true,defaultValue="1")
    	Integer page,@RequestParam (defaultValue="10")Integer size){
		Page<Map<Object, Object>> pageData = getS().selectBlogPage(new Page<Map<Object,Object>>(page,size));
		return Rest.okData(pageData);
		
    }
}
