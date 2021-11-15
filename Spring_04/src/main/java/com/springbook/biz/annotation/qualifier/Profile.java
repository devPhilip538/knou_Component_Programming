package com.springbook.biz.annotation.qualifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Profile {
    private static final Logger logger = LoggerFactory.getLogger(Profile.class);
    @Autowired
    @Qualifier("student1")
    private Student student;

    public Profile() {
        logger.info("profile 객체 생성");
    }

    public void printAge() {
        logger.info("printAge:" + this.student.getAge());
    }

    public void printName() {
        logger.info("printAge:" + this.student.getName());
    }


}
