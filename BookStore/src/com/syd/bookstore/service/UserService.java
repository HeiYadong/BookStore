package com.syd.bookstore.service;

import com.syd.bookstore.bean.User;

/**
 * �������ҵ�񷽷��Ľ��
 * @author Administrator
 *
 */
public interface UserService {
	//�����¼ҵ�񷽷�������һ��User�����������Ϊ�գ���¼�ɹ�������ʧ��
	User login(User user);
	//����ע��ҵ�񷽷� ����trueע��ɹ� falseʧ�� 
	boolean regist(User user);
}
