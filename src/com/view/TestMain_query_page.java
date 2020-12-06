package com.view;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.domain.Student;
import com.util.HibernateUtil;

//分页查询
public class TestMain_query_page {
	public static void main(String[] args) {
		//query_fy();//分页查询
		showResultByPage(4);
	}
	
	/**
	 *2.分页查询函数
	 * */
	private static void showResultByPage(int pageSize) {
		//设置分页变量
		int pageNow=1;//当前页码数
		int pageCount=1;//页面总数
		int rowCount=1;//数据总数
		
		Session session=null;
		Transaction ts=null;
		try {
			session=HibernateUtil.getCurrentSession();
			ts=session.beginTransaction();
			//
			String sql="select count(*) from Student";
			Object obj = session.createQuery(sql).uniqueResult();
			rowCount=Integer.parseInt(obj.toString());//查询数据总数
			//计算总页数
			pageCount=(rowCount-1)/pageSize+1;
			//将每页数据遍历出来
			for(int i=0;i<pageCount;i++){
				int dataIdx=i*pageSize;
				List<Student> list = session.createQuery("from Student").setFirstResult(dataIdx).setMaxResults(pageSize).list();
				System.out.println("************第"+(i+1)+"页**********");
				//遍历结果集(for增强)
				for(Student s:list){
					System.out.println(s.getSname()+" "+s.getSdept());
				}
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
	
	
	/**
	 *1.分页查询
	 * */
	private static void query_fy() {
		Session session=null;
		Transaction ts=null;
		try {
			session=HibernateUtil.getCurrentSession();
			ts=session.beginTransaction();
			
			
			//按照学生的年龄从小->大，取出第1到第3个学生
			String sql="select sname,sage from  Student order by sage asc";
			Query query=session.createQuery(sql).setFirstResult(2).setMaxResults(3);
			List<Object[]> list=query.list();
			for(Object[] obj:list){
				System.out.println(obj[0].toString()+"---"+obj[1].toString());
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
