package com.imooc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.domain.Girl;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.GirlException;
import com.imooc.repository.GirlRespository;

@Service
public class GirlService {
	
	@Autowired
	private GirlRespository girlRepository;
	@Transactional
	public void insertTwo(){
		
		Girl girlA = new Girl();
		girlA.setCupSize("A");
		girlA.setAge(19);
		girlRepository.save(girlA);
		
		Girl girlB = new Girl();
		girlB.setCupSize("Bbbb");
		girlB.setAge(11);
		girlRepository.save(girlB);
	}
	
	
	public void getAge(Integer id) throws Exception{
		Girl girl = girlRepository.findOne(id);
		Integer age = girl.getAge();
		if(age < 10){
			throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
		}else if(age >10 && age < 16){
			throw new GirlException(ResultEnum.PRIMAR_SCHOOL);
		}
	}
	
	/**
	 * 通过Id查询一个女生得信息
	 * @param id
	 * @return
	 */
	public Girl findOne(Integer id){
		return girlRepository.findOne(id);
		
	}
	
	
	
}
