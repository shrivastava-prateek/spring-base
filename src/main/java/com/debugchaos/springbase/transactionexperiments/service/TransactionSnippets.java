package com.debugchaos.springbase.transactionexperiments.service;

import com.debugchaos.springbase.transactionexperiments.dao.FooDao;
import com.debugchaos.springbase.transactionexperiments.dao.FooDao2;
import com.debugchaos.springbase.transactionexperiments.entity.Foo;

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

	// @Transactional(propagation = Propagation.REQUIRED, value = "postgresJpaTransaction2")
	@Transactional(propagation = Propagation.REQUIRED, value = "postgres2Transaction")
	public void addFoo(Foo foo) {
		Foo foo3 = new Foo();
		foo3.setName(foo.getName()+" from Transaction Snippets");
		dao2.addFoo(foo3);
	}

	public void addAnotherFoo(Foo foo) {
		Foo foo2 = new Foo();
		foo2.setName(foo.getName() + " from Transaction Snippets Another method");
		dao.addFoo(foo2);

		//This is to test rollback in JTA, in both database entries should not persist
		//throw new RuntimeException();
	}
	
}
