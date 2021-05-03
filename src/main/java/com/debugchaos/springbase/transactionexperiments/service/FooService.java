package com.debugchaos.springbase.transactionexperiments.service;

import java.util.List;

import com.debugchaos.springbase.transactionexperiments.dao.FooDao;
import com.debugchaos.springbase.transactionexperiments.entity.Foo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional
public class FooService {

	@Autowired
	private FooDao dao;

	@Autowired
	private TransactionSnippets snippets;

	public List<Foo> findAll() {
		return dao.findAll();
	}

	// @Transactional(value = "postgresJpaTransaction")
	@Transactional(value = "postgresJpaTransactionJta")
	public void addFoo(Foo foo){
		dao.addFoo(foo);
		snippets.addFoo(foo);
		addAnotherFoo(foo);
		
	}

	// if the below method is called from addFoo then a new transaction 
	// won't be created because of the proxy, the methods called in 
	// the same class will be called as normal methods
	
	//@Transactional(propagation = Propagation.REQUIRES_NEW, value = "postgresJpaTransaction")
	public void addAnotherFoo(Foo foo) {
		Foo foo2 = new Foo();
		foo2.setName(foo.getName()+" from Foo Service Another method");
		dao.addFoo(foo2);
		snippets.addAnotherFoo(foo);
	}







}


