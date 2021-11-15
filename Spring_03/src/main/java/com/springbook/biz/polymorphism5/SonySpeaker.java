package com.springbook.biz.polymorphism5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SonySpeaker implements Speaker {
    private static final Logger logger = LoggerFactory.getLogger(SonySpeaker.class);
    public SonySpeaker(){
        logger.info("SonySpeaker 객체생성");
    }

    @Override
    public void volumeUp() {
        logger.info("SonySpeaker---소리를 올린다.");
    }

    @Override
    public void volumeDown() {
        logger.info("SonySpeaker---소리를 내린다.");
    }
}
