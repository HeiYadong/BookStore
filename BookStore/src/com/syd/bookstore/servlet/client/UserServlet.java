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
	
		//创建一个UserService对象
	private UserService userService = new UserServiceImpl();   
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*//获取用户填写的用户名密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//封装成User对象
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
		
		//将上述公有部分提取到WEBUtils类里边
		/*User user = new User();
		WEBUtils.paramToBean(request, user);*/
		
		
		
		User loginUser = userService.login(user);
		//判断loginUser是否为空
		if(loginUser == null){
			//设置一个错误消息
			request.setAttribute("msg","用户名或密码有误!");
			//为空的话登录失败，转发到login.html
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}else{
			//登录成功，重定向到login_success。html"
			
			//request.getContextPath()获取项目路径
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
		}
	}
	
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取用户填写信息
		/*String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");*/
		
		/*Map map = request.getParameterMap();
		//将信息封装成对象
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
		//判断isRegist是否注册成功
		if(isRegist){
			//注册成功重定向到regist_success.html
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
		}else{
			//设置一个错误消息
			request.setAttribute("error","用户名已被占用!");
			//注册失败转发到regist.html
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}

	}
}
