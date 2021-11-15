package com.springbook.biz.collectionList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class CollectionBeanClient {
    private static final Logger logger = LoggerFactory.getLogger(CollectionBeanClient.class);
    public static void main(String[] args) {
        AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext6.xml");
        CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
        List<String> addressList = bean.getAddressList();
        for(String address:addressList) {
            logger.info(address.toString());
        }

    }
}
