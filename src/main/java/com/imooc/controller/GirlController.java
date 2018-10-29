package com.imooc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.domain.Girl;
import com.imooc.repository.GirlRespository;
import com.imooc.service.GirlService;

@RestController
public class GirlController {

	@Autowired
	private GirlRespository girlRespository;
	@Autowired
	private GirlService GirlService;
	
	@GetMapping("/girls")
	public List<Girl> girlList(){
		
		return girlRespository.findAll();
		
	}
	
	@PostMapping("/girls")
	public List<Girl> girlAdd(@RequestParam("cupSize") String cupSize,
			@RequestParam("age") Integer age){
		
		return girlRespository.findAll();
		
	}
	
	//增删改查,都可以通过接口接口实现,
	
	
	@PostMapping("/girls/two")
	public void girlTwo(){
		GirlService.insertTwo();
	}
	
}
