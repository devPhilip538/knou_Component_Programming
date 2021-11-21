package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.springbook.biz.user.UserServiceClient;
import com.springbook.biz.user.UserVO;

public class LoginLogging {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceClient.class);
	/* 오승필/202184-010073 */
	public void log(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getDeclaringTypeName();
		if (returnObj instanceof UserVO) {
			UserVO board = (UserVO) returnObj;
			logger.info("====================================");
			logger.info("[사용자 접근 Logging]사용자 ID :" + board.getId());
			logger.info("[사용자 접근 Logging] 사용자의 접근함수 :" + method);
			logger.info("====================================");
		}
	}

}
