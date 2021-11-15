package com.springbook.biz.polymorphism;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SonySpeaker {
    private static final Logger logger = LoggerFactory.getLogger(SonySpeaker.class);
    public SonySpeaker() {
        logger.info("SonySpeaker 객체생성");
    }

    public void volumeUp() {
        logger.info("SonySpeaker---소리를 올린다.");
    }

    public void volumeDown() {
        logger.info("SonySpeaker---소리를 내린다.");
    }

}
