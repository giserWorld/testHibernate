package com.view;

import java.util.List;

import com.domain.Course;
import com.domain.Student;
import com.util.HibernateUtil;

//hibernate工具类查询
public class TestMain_util {
	public static void main(String[] args) {
		//query_allProps();//全部属性查询
		//query_bindParam();//绑定参数查询
		//query_page();//分页查询
		save_data();//保存数据
	}//main

	//保存数据
	private static void save_data(){
		Course newCourse=new Course();
		newCourse.setCid(61);
		newCourse.setCname("postgresql");
		newCourse.setCcredit("2");
		HibernateUtil.save(newCourse);
	}//e 
	
	
	//分页查询
	private static void query_page() {
		String hql="from Student order by sage";
		String[] parameters=null; 
		List<Student> list = HibernateUtil.executeQueryByPage(hql, parameters, 2, 3);
		//全部属性
		for(Student s:list){
			System.out.println(s.getSname()+" "+s.getSage());
		}
	}//e
	
	
	//绑定参数查询
	private static void query_bindParam() {
		String hql2="from Student where sdept=? and sage>cast(? as int)";
		String hql="select sname,saddress from Student where sdept=? and sage>cast(? as int)";
		String[] parameters={"计算机系","2"}; 
		List<Object[]> list = HibernateUtil.executeQuery(hql,parameters);
		
		//全部属性
		/*for(Student s:list){
			System.out.println(s.getSname()+" "+s.getSage());
		}*/
		
		//部分属性
		for(Object[] objs:list){
			System.out.println(objs[0].toString()+" "+objs[1].toString());
		}
		
		
	}//e
	
	//全部属性查询
	private static void query_allProps() {
		String hql="from Student";
		String[] parameters=null;
		List<Student> list = HibernateUtil.executeQuery(hql,parameters);
		for(Student s:list){
			System.out.println(s.getSname()+" "+s.getSage());
		}
	}//e
}
