package com.springbook.biz.annotation.autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Checker {
    private static final Logger logger = LoggerFactory.getLogger(Checker.class);
    public static void main(String[] args) {
        AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext3.xml");
        TextEditor textEditor = (TextEditor) factory.getBean("textEditor");

        textEditor.textSpellChecker();

    }
}
