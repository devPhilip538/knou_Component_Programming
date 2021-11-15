package com.springbook.biz.polymorphism5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SamsungTV implements TV {
	private static final Logger logger = LoggerFactory.getLogger(SamsungTV.class);
	private Speaker speaker;
	private int price;

	public SamsungTV() {
		logger.info("SamsungTV 객체생성");
	}

	public void setSpeaker(Speaker speaker) {
		logger.info("SamsungTV setSpeaker");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		logger.info("SamsungTV setPrice");
		this.price = price;
	}

	@Override
	public void powerOn() {
		logger.info("SamsungTV---전원을 켠다.");
	}

	@Override
	public void powerOff() {
		logger.info("SamsungTV---전원을 끈다.");
	}

	@Override
	public void volumeUp() {
		logger.info("SamsungTV---소리를 올린다.price : " + price + ")");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		logger.info("SamsungTV---소리를 내린다");
		speaker.volumeDown();
	}
}
