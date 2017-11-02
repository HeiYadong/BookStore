package com.syd.bookstore.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WEBUtils {
	public static <T>T paramToBean(HttpServletRequest request,T t){
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(t, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return t;
	}
}
