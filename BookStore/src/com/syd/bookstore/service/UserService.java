package com.syd.bookstore.service;

import com.syd.bookstore.bean.User;

/**
 * 定义相关业务方法的借口
 * @author Administrator
 *
 */
public interface UserService {
	//处理登录业务方法，返回一个User对象，如果对象不为空，登录成功，否则失败
	User login(User user);
	//处理注册业务方法 返回true注册成功 false失败 
	boolean regist(User user);
}
