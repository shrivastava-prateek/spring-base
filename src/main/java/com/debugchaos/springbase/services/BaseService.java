package com.debugchaos.springbase.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BaseService implements IBaseService{
	

	@Override
	public void print(){
		System.out.println("Inside Base Service");
	}
}
