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
	//��ȡQueryRunner
	private QueryRunner runner = new QueryRunner();
	//���巺������
	private Class<T> type;
	public BaseDao() {
		//����������Ǳ��������
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		//��ȡ���͵�����
		type =(Class<T>) pt.getActualTypeArguments()[0];
	}
	
	//����ִ����ɾ�ĵĲ���������Ӱ�������
	public int update(String sql,Object...params){
		int count = 0;
		//��ȡ���ݿ�����
		Connection con = JDBCUtils.getConnection();
		//ִ��sql
		try {
			count = runner.update(con, sql, params);
			System.out.println("���ݿ�����ɹ�,"+count+"����Ӱ��");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con);
		}
		return count;
	}
	
	//��ѯһ������
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
		
		//��ѯһ�����
		public List<T> getBeanList(String sql,Object...params){
			//����һ��List
			List<T> list = null;
			//��ȡ���ݿ�����
			Connection con = JDBCUtils.getConnection();
			//ִ�в�ѯ
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
