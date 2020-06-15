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
	 * find all users
	 * 
	 * @return all user list
	 */
	public Iterable<TUser> findAll() {

		logger.info(this.getClass().getName() + " findAll enter...");

		// get users
		Iterable<TUser> userList = userDao.findAll();

		logger.info(this.getClass().getName() + " findAll completed.");

		return userList;
	}

	/**
	 * find user by id
	 * 
	 * @param id user id
	 * 
	 * @return TUser
	 */
	public TUser findById(Integer id) {

		logger.info(this.getClass().getName() + " findById enter...");

		// get users
		TUser user = userDao.findOne(id);

		logger.info(this.getClass().getName() + " findById completed.");

		return user;
	}

	/**
	 * Create/Update user
	 * 
	 * @param userEntity TUser
	 */
	public void save(TUser userEntity) {

		logger.info(this.getClass().getName() + " save enter...");

		// save user
		userDao.save(userEntity);

		logger.info(this.getClass().getName() + " save completed.");
	}

	/**
	 * Delete user by id
	 * 
	 * @param id user id
	 * @return -1:failed; 1:success
	 */
	public int deleteById(int id) {

		logger.info(this.getClass().getName() + " deleteById enter...");

		// get user
		TUser user = userDao.findOne(id);

		if (user == null) {
			return -1;
		}

		// delete user
		userDao.delete(id);

		logger.info(this.getClass().getName() + " deleteById completed.");

		return 1;
	}

	/**
	 * get new id
	 * 
	 * @return id
	 */
	public int getNewId() {

		logger.info(this.getClass().getName() + " getNewId enter...");

		// get max id
		Integer maxId = userDao.getMaxId();
		if (maxId == null) {
			maxId = 0;
		}

		logger.info(this.getClass().getName() + " getNewId completed.");

		return maxId + 1;
	}
}
