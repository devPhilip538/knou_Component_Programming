package com.springbook.biz.polymorphism;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LgTV {
	private static final Logger logger = LoggerFactory.getLogger(LgTV.class);
	
	public void turnOn() {
		logger.info("LgTV---전원을 켠다.");
	}
	
	public void turnOff() {
		logger.info("LgTV---전원을 끈다.");
	}
	
	public void soundUp() {
		logger.info("LgTV---소리를 올린다.");
	}
	
	public void soundDown() {
		logger.info("LgTV---소리를 내린다");
	}

}
