package com.syd.bookstore.dao;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.syd.bookstore.jdbc.JDBCUtils;

public class BaseDao<T> {
	//获取QueryRunner
	private QueryRunner runner = new QueryRunner();
	//定义泛型类型
	private Class<T> type;
	public BaseDao() {
		//这个构造器是被子类调用
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获取泛型的类型
		type =(Class<T>) pt.getActualTypeArguments()[0];
	}
	
	//用于执行增删改的操作，返回影响的行数
	public int update(String sql,Object...params){
		int count = 0;
		//获取数据库连接
		Connection con = JDBCUtils.getConnection();
		//执行sql
		try {
			count = runner.update(con, sql, params);
			System.out.println("数据库操作成功,"+count+"行受影响");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con);
		}
		return count;
	}
	
	//查询一个对象
		public T getBean(String sql,Object...params){
			T t = null;
			Connection con = JDBCUtils.getConnection();
			try {
				t= runner.query(con,sql, new BeanHandler<T>(type),params);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCUtils.close(con);
			}
			return t;
			
		}
		
		//查询一组对象
		public List<T> getBeanList(String sql,Object...params){
			//定义一个List
			List<T> list = null;
			//获取数据库连接
			Connection con = JDBCUtils.getConnection();
			//执行查询
			try {
				list = runner.query(con,sql, new BeanListHandler<T>(type),params);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JDBCUtils.close(con);
			}
			
			return list;
		}
}
