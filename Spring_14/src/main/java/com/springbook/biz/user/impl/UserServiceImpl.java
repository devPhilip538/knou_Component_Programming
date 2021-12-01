package com.springbook.biz.user.impl;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/* 오승필/202184-010073 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDAO userDAO;

    /* 오승필/202184-010073 */
    @Override
    public UserVO getUser(UserVO vo) {
        logger.info("getUser() 호출", vo);
        return userDAO.getUser(vo);
    }
}
