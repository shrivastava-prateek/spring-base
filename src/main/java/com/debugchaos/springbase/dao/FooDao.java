package com.debugchaos.springbase.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.debugchaos.springbase.entity.Foo;

import org.springframework.stereotype.Repository;

@Repository
public class FooDao {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Foo> findAll() {
		return entityManager.createQuery("from " + Foo.class.getName()).getResultList();
	}

	public void addFoo(Foo foo){
		entityManager.persist(foo);
	}
}
