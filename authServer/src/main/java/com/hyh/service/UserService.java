package com.hyh.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hyh.dao.UserDao;
import com.hyh.entity.TUser;

@Component
public class UserService {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private UserDao userDao;

	/**
	 * find user by email and password
	 * 
	 * @param email
	 * @param password
	 * 
	 * @return TUser
	 */
	public TUser findByEmailPwd(String email, String password) {

		logger.info(this.getClass().getName() + " findByEmailPwd enter...");

		// get user by email and password
		TUser user = userDao.findByEmailPwd(email, password);

		logger.info(this.getClass().getName() + " findByEmailPwd completed.");

		return user;
	}
}
