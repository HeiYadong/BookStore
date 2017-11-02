package com.syd.bookstore.dao;

import com.syd.bookstore.bean.User;

/**
 * UserDao是定义数据库操作的接口
 * @author Administrator
 *
 */
public interface UserDao {
	//根据用户名和密码查询用户对象
	User getUserByUsernameAndPassword(User user);
	
	//向数据库中插入一个用户对象
	int saveUser(User user);
}
