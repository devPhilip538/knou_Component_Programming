package com.springbook.biz.collectionProp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.*;

public class CollectionBeanClient {
    private static final Logger logger = LoggerFactory.getLogger(CollectionBeanClient.class);
    public static void main(String[] args) {
        AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext9.xml");
        CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
        Properties addressList = bean.getAddressList();

        for (Object i : addressList.keySet()) {
            logger.info((String) i + ":" + addressList.getProperty((String) i));
        }

    }
}
