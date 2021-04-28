package com.debugchaos.springbase.services;

import java.util.List;

import com.debugchaos.springbase.dao.FooDao;
import com.debugchaos.springbase.dao.FooDao2;
import com.debugchaos.springbase.entity.Foo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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

	@Transactional(value = "postgresJpaTransaction")
	public void addFoo(Foo foo){
		dao.addFoo(foo);
		snippets.addFoo(foo);
		addAnotherFoo(foo);
		
	}

	//@Transactional(propagation = Propagation.REQUIRES_NEW, value = "postgresJpaTransaction")
	public void addAnotherFoo(Foo foo) {
		Foo foo2 = new Foo();
		foo2.setName(foo.getName()+" from Foo Service Another method");
		dao.addFoo(foo2);
		snippets.addAnotherFoo(foo);
	}




}


