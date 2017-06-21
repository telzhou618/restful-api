package com.restful.api.core.controller;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.baomidou.mybatisplus.service.IService;
import com.restful.api.core.Rest;
import com.restful.api.core.ex.NotFindDataException;
import com.restful.api.core.util.ValidateUtil;

/**
 * Rest CRUD 超级控制器,目的在于所有继承该控制器的子控制器自带标准的5个Rest接口,包含CRUD
 * Created by Gaojun.Zhou 2017年6月8日
 * 
 * T 表示要操作的实体,实现序列化接口Serializable
 * S 表示调用对象的服务层接口,一班情况下要求存在
 * 
 */
public abstract class CrudController<T extends Serializable,S extends IService<T>> {

	/**
	 * 注入服务层
	 */
	@Autowired(required = false) private S s;
	
	public S getS() {
		return s;
	}

	/**
	 * 
	 * @return
	 */
    @GetMapping
    public  Rest list(){
		List<T> list = s.selectList(null); //查询所有对象,null表示没有条件,会返回所有对象,Mybatis-Plus的特性
		if(!list.isEmpty()){
			return Rest.okData(list);
		}
		throw new NotFindDataException("未查询到任何对象");
		
    }
	
    @GetMapping("/{id}")  
    public  Rest get(@PathVariable("id") Serializable id){
		
    	if(id==null){
			throw new RuntimeException("参数{id}不能为空");
		}
    	if(id instanceof String){
    		if(StringUtils.isBlank((String)id)){
    			throw new RuntimeException("参数{id}不能为空");
    		}
    	}
		T t = s.selectById(id);
		if(t != null){
			return Rest.okData(t);
		}
		throw new NotFindDataException(String.format("id为[%s]的对象不存在",id));
    }
    
	/**
	 * 创建对象
	 * @param t
	 * @param result 验证器，和Mode层配合使用
	 * @return
	 */
	@PostMapping
	public Rest add(@Valid T t,BindingResult result){
		
		if(result.hasErrors()){
			return Rest.failure(500,"参数验证失败",ValidateUtil.toStringJson(result),"error");
		}
		s.insert(t);
		return Rest.ok();
	}
	
    @PutMapping  
    public  Rest update(@Valid T t,BindingResult result){
		if(result.hasErrors()){
			return Rest.failure(500,"参数验证失败",ValidateUtil.toStringJson(result),"error");
		}
		s.updateById(t);
		return Rest.ok();
    }
	
	/**
	 * 删除对象
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public Rest delete(@PathVariable("id") Serializable id){
		
		if(id==null){
			throw new RuntimeException("参数{id}不能为空");
		}
    	if(id instanceof String){
    		if(StringUtils.isBlank((String)id)){
    			throw new RuntimeException("参数{id}不能为空");
    		}
    	}
		T t = s.selectById(id);
		if(t== null){
			throw new NotFindDataException("要删除的对象不存在");
		}else if(s.deleteById(id)){
			return Rest.ok("删除成功");
		}else{
			throw new RuntimeException("糟糕,删除失败");
		}
	}
}
