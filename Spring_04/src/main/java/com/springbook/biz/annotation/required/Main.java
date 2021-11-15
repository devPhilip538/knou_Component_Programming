package com.springbook.biz.annotation.required;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext5.xml");

        Profile profile = (Profile) factory.getBean("profile");

        profile.printName();
        profile.printAge();

    }
}
