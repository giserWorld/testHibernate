package com.view;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.domain.Student;
import com.util.HibernateUtil;

//query参数绑定
public class TestMain_query_setParameter {
	public static void main(String[] args) {
		query_setParameter();//分页查询
	}
	
	
	
	/**
	 *1.参数绑定
	 * */
	private static void query_setParameter() {
		Session session=null;
		Transaction ts=null;
		try {
			session=HibernateUtil.getCurrentSession();
			ts=session.beginTransaction();
			
			//冒号参数绑定
			String sql="from Student where sdept=:sdept and sage>:sage";
			//问号参数绑定
			String sql2="from Student where sdept=? and sage>?";
			Query query=session.createQuery(sql2);
			//冒号参数绑定
			//query.setString("sdept","计算机系");
			//query.setString("sage","2");
			
			//问号参数绑定
			query.setString(0,"计算机系");
			query.setInteger(1,2);
			
			List<Student> list=query.list();
			for(Student s:list){
				System.out.println(s.getSdept()+" "+s.getSage());
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
	}//e
}
