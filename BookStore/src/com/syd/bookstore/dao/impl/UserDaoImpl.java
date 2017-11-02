package com.syd.bookstore.dao.impl;

import com.syd.bookstore.bean.User;
import com.syd.bookstore.dao.BaseDao;
import com.syd.bookstore.dao.UserDao;

public class UserDaoImpl extends BaseDao<User> implements UserDao{

	@Override
	public User getUserByUsernameAndPassword(User user) {
		//´´½¨sqlÄ£°å
		String sql = "SELECT id,username,PASSWORD,email FROM regist WHERE username=? AND PASSWORD=?";
		return this.getBean(sql, user.getUsername(),user.getPassword());
	}

	@Override
	public int saveUser(User user) {
		String sql = "INSERT INTO regist(username,PASSWORD,email)VALUES(?,?,?)";
		return this.update(sql, user.getUsername(),user.getPassword(),user.getEmail());
	}
	
}
