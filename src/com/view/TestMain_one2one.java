package com.view;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.domain.Department;
import com.domain.Idcard;
import com.domain.Person;
import com.util.HibernateUtil;

//一对一关系
public class TestMain_one2one {
	public static void main(String[] args) {
		Session session=null;
		Transaction ts=null;
		try {
			session=HibernateUtil.getCurrentSession();
			ts=session.beginTransaction();
			
			Person p1=new Person();
			p1.setName("小王");
			p1.setId(1234);
			
			Idcard card=new Idcard();
			card.setValidateDte(new Date());
			card.setPerson(p1);
			
			session.save(p1);
			session.save(card);
			
			
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
