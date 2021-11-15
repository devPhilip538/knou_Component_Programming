package com.springbook.biz.polymorphism3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV {
	private static final Logger logger = LoggerFactory.getLogger(LgTV.class);

	@Autowired
	private Speaker speaker;

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
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		logger.info("LgTV---소리를 내린다");
		speaker.volumeDown();
	}
}
