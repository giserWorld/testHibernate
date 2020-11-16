package com.view;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.domain.Student;
import com.util.HibernateUtil;

//查询对象模型的所有属性
public class TestMain_allProps {
	public static void main(String[] args) {
		Session session=null;
		Transaction ts=null;
		try {
			session=HibernateUtil.getCurrentSession();
			ts=session.beginTransaction();
			
			//自动将查询的结果集数据转为javaBean对象
			List<Student> list = session.createQuery("from Student").list();
			//for增强
			for(Student s:list){
				System.out.println(s.getSname()+"-"+s.getSaddress());
			}
			ts.commit();
		} catch (Exception e) {
			if(ts!=null){
				ts.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}
		finally{
			if(session!=null){
				session.close();
			}
		}
	}
}
