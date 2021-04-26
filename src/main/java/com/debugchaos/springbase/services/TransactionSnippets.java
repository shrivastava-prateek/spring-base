package com.debugchaos.springbase.services;

import com.debugchaos.springbase.dao.FooDao;
import com.debugchaos.springbase.entity.Foo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransactionSnippets {

	@Autowired
	FooDao dao;

	@Transactional(propagation = Propagation.SUPPORTS)
	public void addFoo(Foo foo) {
		Foo foo3 = new Foo();
		foo3.setName(foo.getName()+" from Transaction Snippets");
		dao.addFoo(foo3);
	}
	
}
