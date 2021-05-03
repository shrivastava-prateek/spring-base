package com.debugchaos.springbase.transactionexperiments.controller;

import java.util.List;

import com.debugchaos.springbase.scopeexperiments.service.IBaseService;
import com.debugchaos.springbase.transactionexperiments.entity.Foo;
import com.debugchaos.springbase.transactionexperiments.service.FooService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tx")
public class TxExpController {
	

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
