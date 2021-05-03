package com.debugchaos.springbase.scopeexperiments.controller;

import com.debugchaos.springbase.scopeexperiments.service.IBaseService;

import org.springframework.beans.factory.annotation.Autowired;
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
