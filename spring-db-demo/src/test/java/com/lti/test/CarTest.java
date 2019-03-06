package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.component.CarPart;
import com.lti.component.CarPartInventory;

public class CarTest {

	@Test
	public void test() {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

		CarPartInventory car = (CarPartInventory) ctx.getBean("carPartsinventoryImpl");
		CarPart c = new CarPart();
		c.setPartNo(12365);
		c.setName("Aston Martin");
		c.setCarModel("Zx00");
		c.setStock(99);
		car.addNewPart(c);

	}

}
