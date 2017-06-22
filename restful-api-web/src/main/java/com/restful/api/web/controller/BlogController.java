package com.restful.api.web.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.restful.api.core.Rest;
import com.restful.api.core.anno.ForbidMethod;
import com.restful.api.core.anno.Log;
import com.restful.api.core.controller.AppController;
import com.restful.api.web.entity.Blog;
import com.restful.api.web.service.IBlogService;
/**
 * 标准的Rest接口,实例控制器
 * Created by Gaojun.Zhou 2017年6月8日
 */
@RestController
@RequestMapping("/blog")
@ForbidMethod({"delete"}) //禁止客户端调用delete方法,可穿入多个参数
public class BlogController extends AppController<Blog,IBlogService>{  
	
	/**
	 * 自定义方法分页多表连接查询博客
	 */
    @GetMapping("/findJoinPage")  
    public  Rest findJoinPage(@RequestParam (required = true,defaultValue="1")
    	Integer page,@RequestParam (defaultValue="10")Integer size){
		Page<Map<Object, Object>> pageData = getS().selectBlogPage(new Page<Map<Object,Object>>(page,size));
		return Rest.okData(pageData);
		
    }
    
    /**
     * 记录日志测试
     * @see @Log 记录日志只在方法执行成功返回后执行，通过 com.restful.api.core.log.LogAdvice AOP实现
     * @see 开发者可实现 LogApi接口的log方法完成记录日志具体的业务,此项目中完善service下的LogServiceImpl.java的log方法即可
     * @return rest
     */
    @GetMapping("/testLog")
    @Log(title="测试日志",value="这是日志内容,哈哈") 
    public Rest testLog(){
    	return Rest.ok();
    }
    
}
