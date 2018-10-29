package com.imooc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.properties.GirlProperties;
@RestController
public class HelloConteroller {
	
	//@Value("${cupSize}")
	private String cupSize;//通过注解把配置文件的属性 读取
	
	//@Value("${age}")
	private String age;
	
	//@Value("${content}")
	private String content;
	
	@Autowired
	private GirlProperties girlProperties;
	
	
	@RequestMapping(value={"/hello","/hi"},method = RequestMethod.GET)
	public String say(){
		return girlProperties.getCupSize()+girlProperties.getAge();
	}
}
