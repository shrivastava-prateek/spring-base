package com.debugchaos.springbase.controllers;

import java.util.List;

import com.debugchaos.springbase.entity.Foo;
import com.debugchaos.springbase.services.FooService;
import com.debugchaos.springbase.services.IBaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Scope("prototype")
public class BaseController {
	

	@Autowired
	IBaseService baseService;

	@Autowired
	FooService fooService;

	public void indentify(){
		System.out.println(baseService);
		baseService.print();
	}

	@GetMapping(path = "foos")
	public List<Foo> getFoos(){

		return fooService.findAll();
	}

	@PostMapping(path = "foo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addFoo(@RequestBody Foo foo){
		fooService.addFoo(foo);
	}

}
