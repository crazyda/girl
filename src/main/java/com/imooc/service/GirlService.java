package com.imooc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.domain.Girl;
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
}
