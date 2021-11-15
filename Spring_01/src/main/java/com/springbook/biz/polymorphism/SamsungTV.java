package com.springbook.biz.polymorphism;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SamsungTV {
	private static final Logger logger = LoggerFactory.getLogger(SamsungTV.class);
	
	public void powerOn() {
		logger.info("SamsungTV---전원을 켠다.");
	}
	
	public void powerOff() {
		logger.info("SamsungTV---전원을 끈다.");
	}
	
	public void volumeUp() {
		logger.info("SamsungTV---소리를 올린다.");
	}
	
	public void volumeDown() {
		logger.info("SamsungTV---소리를 내린다");
	}

}
