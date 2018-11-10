package com.imooc.exception;

import com.imooc.enums.ResultEnum;

/**
 * 不直接继成exception spring 只RuntimeException 
 * 得异常进行事务得回滚
 * @author Crazy
 *
 */
public class GirlException extends RuntimeException{
	
	private Integer code;

	public GirlException(ResultEnum resultEnum){
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
	}
	
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	
}
