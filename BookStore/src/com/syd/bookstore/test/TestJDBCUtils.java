package com.syd.bookstore.test;

import java.sql.Connection;

import org.junit.Test;

import com.syd.bookstore.jdbc.JDBCUtils;

public class TestJDBCUtils{
	@Test
	public void test(){
		try {
			Connection con = JDBCUtils.getConnection();
			System.out.println(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}