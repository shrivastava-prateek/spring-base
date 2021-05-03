package com.debugchaos.springbase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.debugchaos.springbase.lamdaexperiments.service.LambdaService;
import com.debugchaos.springbase.scopeexperiments.controller.BaseController;
import com.debugchaos.springbase.scopeexperiments.controller.BaseController2;
import com.debugchaos.springbase.scopeexperiments.service.IBaseService;
import com.debugchaos.springbase.transactionexperiments.dao.FooDao;
import com.debugchaos.springbase.transactionexperiments.dao.FooDao2;
import com.debugchaos.springbase.transactionexperiments.entity.Foo;
import com.debugchaos.springbase.transactionexperiments.service.FooService;
import com.debugchaos.springbase.transactionexperiments.service.TransactionSnippets;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
//@RunWith(SpringRunner.class)//not available with junit5
@ExtendWith(MockitoExtension.class)
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = SpringBaseApplication.class)
class SpringBaseApplicationTests {

	@Mock
	//@MockBean
	FooDao dao;
	@Mock
	FooDao2 dao2;

	@InjectMocks
	LambdaService lambdaService;

	@InjectMocks
	BaseController baseController1;

	@InjectMocks
	BaseController2 baseController11;

	@Autowired
	IBaseService baseService;

	@InjectMocks
	TransactionSnippets snippets;

	@InjectMocks
	//@Autowired
	FooService fooService;

	@Test
	void contextLoads() {
	}

	@Test
	void checkAll(){
		List<Foo> foos = new ArrayList<>();
		foos.add(new Foo(1l, "Prateek", 28));
		foos.add(new Foo(2l, "Kunwar", 29));
		foos.add(new Foo(3l, "Axel", 30));
		foos.add(new Foo(4l, "Robin", 31));

		System.out.println("--------------- checkAll---------------");
		when(dao.findAll()).thenReturn(foos);

		assertEquals(4,fooService.findAll().size());


	}


	// This method is to test lambda uses cases
	@Test
	public void lambdaUseCases() {
		List<String> list = Arrays.asList("Lukasz", "Ajitesh", "Brian", "Patrick", "Azer");
		lambdaService.printElements(list);
		System.out.println();
		lambdaService.transformUpper(list);
		System.out.println();
		lambdaService.filterElements(list, "P");
		System.out.println();
		lambdaService.getFirstELement(list, "A");
		System.out.println();
		lambdaService.joinElements(list);
		System.out.println();
		lambdaService.findLargest(list);
		System.out.println();
		lambdaService.sortElements(list);
		System.out.println();
		lambdaService.listAllFiles(".");
		System.out.println();

	}

	// This method is test scope can be tested with Spring boot test
	@Test
	public void checkScope() {

		//BaseController baseController1 = applicationContext.getBean(BaseController.class);
		//BaseController2 baseController11 = applicationContext.getBean(BaseController2.class);
		baseController11.indentify();
		baseController1.indentify();
		// BaseController
		// baseController2=applicationContext.getBean(BaseController.class);
		// BaseController
		// baseController3=applicationContext.getBean(BaseController.class);
		// BaseController
		// baseController4=applicationContext.getBean(BaseController.class);

		// System.out.println(baseController1);
		// System.out.println(baseController2);
		// System.out.println(baseController3);
		// System.out.println(baseController4);

		// baseController2.indentify();
		// baseController3.indentify();
		// baseController4.indentify();
	}



}
