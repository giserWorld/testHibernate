package com.view;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.domain.Student;
import com.util.HibernateUtil;

//查询对象模型的一个属性
public class TestMain_oneProps {
	public static void main(String[] args) {
		Session session=null;
		Transaction ts=null;
		try {
			session=HibernateUtil.getCurrentSession();
			ts=session.beginTransaction();
			
			//自动将查询的结果集数据分装为Object对象数组
			//如果我们返回的是一列数据，这时我们的取法是直接取出，list->object,而不是object[]
			List list = session.createQuery("select sname from Student").list();
			//for增强
			for(Object obj:list){
				System.out.println(obj.toString());
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
