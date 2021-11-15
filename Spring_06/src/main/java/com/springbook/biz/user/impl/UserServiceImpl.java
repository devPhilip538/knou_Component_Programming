package com.springbook.biz.user.impl;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* 오승필/202184-010073 */
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserDAO userDAO;
    /* 오승필/202184-010073 */
    public void setUserDAO(UserDAO userDAO) {
        logger.info("setUserDAO() 호출");
        this.userDAO = userDAO;
    }

    /* 오승필/202184-010073 */
    @Override
    public UserVO getUser(UserVO vo) {
        logger.info("getUser() 호출");
        return userDAO.getUser(vo);
    }
}
