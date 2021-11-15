package com.springbook.biz.polymorphism4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppleSpeaker implements Speaker{
    private static final Logger logger = LoggerFactory.getLogger(AppleSpeaker.class);
    public AppleSpeaker(){
        logger.info("AppleSpeaker 객체생성");
    }

    @Override
    public void volumeUp() {
        logger.info("AppleSpeaker---소리를 올린다.");
    }

    @Override
    public void volumeDown() {
        logger.info("AppleSpeaker---소리를 내린다.");
    }
}
