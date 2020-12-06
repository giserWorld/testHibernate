package com.view;

import java.util.List;

import com.domain.Employee;
import com.domain.Student;
import com.util.HibernateUtil;

//多对一查询
public class TestMain_many2one {
	public static void main(String[] args) {
		String hql="from Employee where name='小花'";
		String[] parameters=null;
		List<Employee> list = HibernateUtil.executeQuery(hql,parameters);
		//全部属性
		for(Employee e:list){
			System.out.println(e.getName()+"---"+e.getDepartment().getName());
		}
	}
}
