package com.springbook.biz.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
/* 오승필/202184-010073 */
public class UserServiceClient {
    
	private static final Logger logger = LoggerFactory.getLogger(UserServiceClient.class);
	
	/* 오승필/202184-010073 */
	public static void main(String[] args) {
        AbstractApplicationContext container =
                new GenericXmlApplicationContext("applicationContext.xml");

        UserService userService = (UserService) container.getBean("userService");

        // 3. 로그인 기능 테스트
        /* 오승필/202184-010073 */
        UserVO vo = new UserVO();
        vo.setId("phil");
        vo.setPassword("password");

        UserVO user = userService.getUser(vo);

        if(user != null) {
            logger.info(user.getName() + "님 환영합니다.");
        } else {
            logger.info("로그인 실패");
        }
        // 4. Spring 컨테이너를 종료한다.
        container.close();

    }
}
