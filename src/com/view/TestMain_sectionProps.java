package com.view;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.domain.Student;
import com.util.HibernateUtil;

//查询对象模型的部分属性
public class TestMain_sectionProps {
	public static void main(String[] args) {
		Session session=null;
		Transaction ts=null;
		try {
			session=HibernateUtil.getCurrentSession();
			ts=session.beginTransaction();
			
			//自动将查询的结果集数据分装为Object对象数组
			List list = session.createQuery("select sname,sdept from Student").list();
			//for循环
			for(int i=0;i<list.size();i++){
				Object [] objs=(Object []) list.get(i);
				System.out.println(objs[0].toString()+" "+objs[1].toString());
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
