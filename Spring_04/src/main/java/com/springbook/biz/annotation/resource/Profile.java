package com.springbook.biz.annotation.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import javax.annotation.Resource;



public class Profile {
    private static final Logger logger = LoggerFactory.getLogger(Profile.class);
    @Resource(name="student1")
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
