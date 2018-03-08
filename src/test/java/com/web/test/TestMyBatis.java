package com.web.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.web.entity.User;
import com.web.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml" })
public class TestMyBatis {

	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	@Resource
	private IUserService userService = null;
	
	@Test
	public void testUserService(){
		User user=userService.getUserById(2);
		logger.info(JSON.toJSONString(user));
		User user1=userService.getUserById(2);
		logger.info(JSON.toJSONString(user1));
		userService.updateUserById(new User(2,"sss",11));
		User user2=userService.getUserById(2);
		logger.info(JSON.toJSONString(user2));
	}
}
