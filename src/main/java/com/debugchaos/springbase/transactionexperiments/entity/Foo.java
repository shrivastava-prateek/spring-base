package com.debugchaos.springbase.transactionexperiments.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Foo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "AGE")
	private Integer age;

	
	public Foo() {
	}

	


	public Foo(Long id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Foo [age=" + age + ", id=" + id + ", name=" + name + "]";
	}

	// default getters and setters

	
}
