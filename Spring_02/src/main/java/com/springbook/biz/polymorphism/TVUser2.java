package com.springbook.biz.polymorphism;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TVUser2 {
	public static void main (String[] args) {
		// ApplicationContext 사례
//		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		//BeanFactory 사례
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext"));
		
		// Spring 컨테이너로부터 tv Bean 요청(Lookup)
		TV tv = (TV)factory.getBean("tv");

		// 요청
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
}