package com.springbook.biz.polymorphism;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LgTV implements TV {
	private static final Logger logger = LoggerFactory.getLogger(LgTV.class);

	public LgTV() {
		logger.info("LgTV 객체생성");
	}

	@Override
	public void powerOn() {
		logger.info("LgTV---전원을 켠다.");
	}

	@Override
	public void powerOff() {
		logger.info("LgTV---전원을 끈다.");
	}

	@Override
	public void volumeUp() {
		logger.info("LgTV---소리를 올린다.");
	}

	@Override
	public void volumeDown() {
		logger.info("LgTV---소리를 내린다");
	}
}
