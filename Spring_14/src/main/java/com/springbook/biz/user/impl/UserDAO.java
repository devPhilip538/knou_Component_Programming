package com.springbook.biz.user.impl;

import com.springbook.biz.user.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/* 오승필/202184-010073 */
@Repository
public class UserDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);
    
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
    /* 오승필/202184-010073 */
    // CRUD 기능의 메소드 구현
    public UserVO getUser(UserVO vo){
        logger.info("===> mybatis로 getUser() 기능 처리");
    	return (UserVO) sqlSessionTemplate.selectOne("UserDAO.getUser", vo);
//    	return (UserVO) vo;

    }
}
