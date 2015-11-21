package org.github.mervyn.SSH.service;

import static org.junit.Assert.*;

import org.github.mervyn.SSH.entity.User;
import org.github.mervyn.SSH.serviceImpl.UserService;
import org.github.mervyn.SSH.util.BaseTransactionalTest;
import org.junit.Test;

public class UserServiceTest extends BaseTransactionalTest {

	@Test
	public void testSave() {
		User user = new User();
		user.setUsername("testSaveService");
		
		IUserService  userService = (IUserService) this.getBean("userService");
		userService.save(user);
		logger.debug("UserService的void save(User user)正确。");
		
	}

}
