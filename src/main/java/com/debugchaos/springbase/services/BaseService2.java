package com.debugchaos.springbase.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseService2 implements IBaseService {

	@Override
	public void print(){
		System.out.println("Inside Base Service 2");
	}
}
