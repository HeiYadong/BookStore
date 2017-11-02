package com.syd.bookstore.servlet.client;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName = request.getParameter("method");
		//System.out.println(parameter);
		/*if("login".equals(parameter)){
			login(request, response);
		}else if("regist".equals(parameter)){
			regist(request, response);
		}*/
		try {
			Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			//设置一个权限
			method.setAccessible(true);
			//执行方法
			method.invoke(this,request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("BaseServlet异常了");
			e.printStackTrace();
		} 
	}
			
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
}
