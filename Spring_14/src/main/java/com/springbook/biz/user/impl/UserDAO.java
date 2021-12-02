package com.springbook.biz.user.impl;

import com.springbook.biz.user.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/* 오승필/202184-010073 */
@Repository
public class UserDAO extends SqlSessionDaoSupport {
	private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    /* 오승필/202184-010073 */
    // CRUD 기능의 메소드 구현
    public UserVO getUser(UserVO vo){
        logger.info("===> mybatis로 getUser() 기능 처리");
    	return (UserVO) getSqlSession().selectOne("UserDAO.getUser", vo);

    }
}
