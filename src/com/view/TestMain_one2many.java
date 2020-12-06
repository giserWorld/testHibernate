package com.view;

import java.util.List;
import java.util.Set;

import com.domain.Department;
import com.domain.Employee;
import com.util.HibernateUtil;

//一对多查询
public class TestMain_one2many {
	public static void main(String[] args) {
		String hql="from Department where name='业务部'";
		String[] parameters=null;
		List<Department> list = HibernateUtil.executeQuery(hql, parameters);
		//全部属性
		for(Department d:list){
			System.out.println("*******"+d.getName()+"*********");
			
			//懒加载问题
			Set<Employee> employees = d.getEmployees();
			for(Employee e:employees){
				System.out.println(e.getName());
			}
		}
	}
}
