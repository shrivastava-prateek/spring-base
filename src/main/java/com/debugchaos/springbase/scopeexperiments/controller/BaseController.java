package com.debugchaos.springbase.scopeexperiments.controller;

import com.debugchaos.springbase.scopeexperiments.service.IBaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Scope("prototype")
public class BaseController {
	

	@Autowired
	IBaseService baseService;

	public void indentify(){
		System.out.println(baseService);
		baseService.print();
	}

}
