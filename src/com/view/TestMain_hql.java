package com.view;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.domain.Student;
import com.util.HibernateUtil;

//查询对象模型的所有属性
public class TestMain_hql {
	public static void main(String[] args) {
		//query_uniqueResult();//uniqueResult唯一值查询
		query_multiTable();//多表查询
	}
	
	/**
	 *1.多表查询
	 * */
	private static void query_multiTable() {
		Session session=null;
		Transaction ts=null;
		try {
			session=HibernateUtil.getCurrentSession();
			ts=session.beginTransaction();
			//计算各个科目不及格的学生数量
			String sql1="select student.sname,course.cname,grade from Studcourse where grade>=60";
			//
			String sql="select count(*),student.sdept ,'no' from Studcourse where grade<60 group by student.sdept";
			List<Object[]> list=session.createQuery(sql).list();
			for(Object[] obj:list){
				System.out.println(obj[0].toString()+"-"+obj[1].toString()+"-"+obj[2].toString());
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
	
	
	/**
	 *1.uniqueResult()方法查询结果会有很高的查询效率,一般用于主键查询
	 *2.高效查询
	 * */
	private static void query_uniqueResult() {
		Session session=null;
		Transaction ts=null;
		try {
			session=HibernateUtil.getCurrentSession();
			ts=session.beginTransaction();
			
			//uniqueResult为唯一结果值,自动将查询的结果集数据转为javaBean对象
			Student s = (Student)session.createQuery("from Student where sid=20050003").uniqueResult();
			System.out.println(s.getSname()+" "+s.getSage());
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
