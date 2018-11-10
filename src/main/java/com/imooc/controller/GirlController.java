package com.imooc.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.aspect.HttpAspect;
import com.imooc.domain.Girl;
import com.imooc.domain.Result;
import com.imooc.repository.GirlRespository;
import com.imooc.service.GirlService;
import com.imooc.utils.ResultUtil;

@RestController
public class GirlController {

	@Autowired
	private GirlRespository girlRespository;
	@Autowired
	private GirlService GirlService;
	
	private final static Logger  logger = org.slf4j.LoggerFactory.getLogger(GirlController.class);
	@GetMapping("/girls")
	public List<Girl> girlList(){
		logger.info("girls");
		
		return girlRespository.findAll();
		
	}
	
	@PostMapping("/girls_1")
	public List<Girl> girlAdd(@RequestParam("cupSize") String cupSize,
			@RequestParam("age") Integer age){
		
		return girlRespository.findAll();
		
	}
	
	//增删改查,都可以通过接口接口实现,
	@PostMapping("/girls/two")
	public void girlTwo() throws Exception{
		//GirlService.getAge(id);
		GirlService.insertTwo();
	}
	
	@PostMapping(value = "/girls")
	public Result<Girl> girlAdd(@Valid Girl girl,
			BindingResult bindingResult){
		
		if(bindingResult.hasErrors()){
			return ResultUtil.error(0, bindingResult.getFieldError().getDefaultMessage()) ;
		}
		girl.setCupSize(girl.getCupSize());
		girl.setAge(girl.getAge());
		return ResultUtil.success(girlRespository.save(girl));
		
	}
	
	@GetMapping(value="getAge")
	public void getAge(@RequestParam("id") Integer id) throws Exception{
		logger.info("获取到得id:"+id);
		GirlService.getAge(id);
	}
	
	
	
	
	
}
