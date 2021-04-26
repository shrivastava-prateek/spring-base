package com.debugchaos.springbase.controllers;

import com.debugchaos.springbase.services.BaseService;
import com.debugchaos.springbase.services.IBaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
//@Scope("prototype")
public class BaseController2 {
	

	@Autowired
	IBaseService baseService;

	public void indentify(){
		System.out.println(baseService);
		baseService.print();
	}

}
