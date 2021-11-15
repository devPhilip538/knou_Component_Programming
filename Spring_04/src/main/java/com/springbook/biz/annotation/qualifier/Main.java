package com.springbook.biz.annotation.qualifier;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext4.xml");

        Profile profile = (Profile) factory.getBean("profile");

        profile.printName();
        profile.printAge();

    }
}
