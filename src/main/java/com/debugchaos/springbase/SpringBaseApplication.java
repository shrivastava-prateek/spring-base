package com.debugchaos.springbase;

import java.util.Arrays;
import java.util.List;

import com.debugchaos.springbase.controllers.BaseController;
import com.debugchaos.springbase.controllers.BaseController2;
import com.debugchaos.springbase.services.LambdaService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBaseApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringBaseApplication.class, args);

		//lambdaUseCases(applicationContext);

	}

	public static void lambdaUseCases(ApplicationContext applicationContext) {
		List<String>  list          = Arrays.asList("Lukasz", "Ajitesh", "Brian", "Patrick", "Azer");
		LambdaService lambdaService = applicationContext.getBean(LambdaService.class);
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

	public static void checkScope(ApplicationContext applicationContext) {
		
		BaseController  baseController1  = applicationContext.getBean(BaseController.class);
		BaseController2 baseController11 = applicationContext.getBean(BaseController2.class);
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
