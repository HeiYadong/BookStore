package com.syd.bookstore.dao;

import com.syd.bookstore.bean.User;

/**
 * UserDao�Ƕ������ݿ�����Ľӿ�
 * @author Administrator
 *
 */
public interface UserDao {
	//�����û����������ѯ�û�����
	User getUserByUsernameAndPassword(User user);
	
	//�����ݿ��в���һ���û�����
	int saveUser(User user);
}
