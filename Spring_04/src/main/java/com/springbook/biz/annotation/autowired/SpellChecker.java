package com.springbook.biz.annotation.autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpellChecker {
    private static final Logger logger = LoggerFactory.getLogger(SpellChecker.class);
    public SpellChecker() {
        logger.info("SpellChecker 객체 생성");
    }

    public void checkSpeclling () {
        logger.info("checkSpeclling 호출");
    }
}
