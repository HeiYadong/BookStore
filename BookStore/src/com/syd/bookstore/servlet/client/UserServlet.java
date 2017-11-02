package com.syd.bookstore.servlet.client;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.syd.bookstore.bean.User;
import com.syd.bookstore.impl.UserServiceImpl;
import com.syd.bookstore.service.UserService;
import com.syd.bookstore.util.WEBUtils;

public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
		//����һ��UserService����
	private UserService userService = new UserServiceImpl();   
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*//��ȡ�û���д���û�������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//��װ��User����
		User user = new User(null,username,password,null);*/
		
		Map map = request.getParameterMap();
		//request.setAttribute("mapp", map);
		User user = new User();
		try {
			BeanUtils.populate(user, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//���������в�����ȡ��WEBUtils�����
		/*User user = new User();
		WEBUtils.paramToBean(request, user);*/
		
		
		
		User loginUser = userService.login(user);
		//�ж�loginUser�Ƿ�Ϊ��
		if(loginUser == null){
			//����һ��������Ϣ
			request.setAttribute("msg","�û�������������!");
			//Ϊ�յĻ���¼ʧ�ܣ�ת����login.html
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}else{
			//��¼�ɹ����ض���login_success��html"
			
			//request.getContextPath()��ȡ��Ŀ·��
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
		}
	}
	
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//��ȡ�û���д��Ϣ
		/*String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");*/
		
		/*Map map = request.getParameterMap();
		//����Ϣ��װ�ɶ���
		User user = new User();
		try {
			BeanUtils.populate(user, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	*/
		
		User user = new User();
		WEBUtils.paramToBean(request, user);
		
		boolean isRegist = userService.regist(user);
		//�ж�isRegist�Ƿ�ע��ɹ�
		if(isRegist){
			//ע��ɹ��ض���regist_success.html
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
		}else{
			//����һ��������Ϣ
			request.setAttribute("error","�û����ѱ�ռ��!");
			//ע��ʧ��ת����regist.html
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}

	}
}
