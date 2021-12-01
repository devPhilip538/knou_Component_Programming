package com.springbook.biz.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;
import java.io.Reader;

public class SqlSessionFactoryBean {
    /* 오승필/202184-010073 */
    private static SqlSessionFactory sessionFactory = null;
    static {
        try {
            System.out.println(sessionFactory);
            if (sessionFactory == null) {
                Reader reader = Resources.getResourceAsReader("sql-map-config.xml");
                sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSessionInstance() {
        return sessionFactory.openSession(true);
    }
}
