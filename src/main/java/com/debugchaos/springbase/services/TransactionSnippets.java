package com.debugchaos.springbase.services;

import com.debugchaos.springbase.dao.FooDao;
import com.debugchaos.springbase.dao.FooDao2;
import com.debugchaos.springbase.entity.Foo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionSnippets {

	@Autowired
	private FooDao2 dao2;

	@Autowired
	private FooDao dao;

	@Transactional(propagation = Propagation.REQUIRED, value = "postgresJpaTransaction2")
	public void addFoo(Foo foo) {
		Foo foo3 = new Foo();
		foo3.setName(foo.getName()+" from Transaction Snippets");
		dao2.addFoo(foo3);
	}

	public void addAnotherFoo(Foo foo) {
		Foo foo2 = new Foo();
		foo2.setName(foo.getName() + " from Transaction Snippets Another method");
		dao.addFoo(foo2);
		throw new RuntimeException();
	}
	
}
