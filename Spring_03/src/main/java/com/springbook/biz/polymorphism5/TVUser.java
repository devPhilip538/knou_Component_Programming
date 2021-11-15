package com.springbook.biz.polymorphism5;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main (String[] args) {
		// Spring 컨테너 구동
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext5.xml");
		
		// Spring 컨테이너로부터 tv Bean 요청(Lookup)
		TV tv = (TV)factory.getBean("tv5");

		// 요청
		tv.volumeUp();
		tv.volumeDown();
	}
}