package com.syd.bookstore.impl;

import com.syd.bookstore.bean.User;
import com.syd.bookstore.dao.UserDao;
import com.syd.bookstore.dao.impl.UserDaoImpl;
import com.syd.bookstore.service.UserService;

public class UserServiceImpl implements UserService{
	UserDao userDao = new UserDaoImpl();
	@Override
	public User login(User user) {
		return userDao.getUserByUsernameAndPassword(user);
	}

	@Override
	public boolean regist(User user) {
		int count = userDao.saveUser(user);
		return count == 1;//true
	}
	
}
