package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

final public class HibernateUtil {
	private static SessionFactory sessionFactory=null;
	private static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
	static{
		//通过配置获取sessionFactory对象(只运行一次),默认获取hibernate.cfg.xml文件
		Configuration config=new Configuration().configure();
		sessionFactory=config.buildSessionFactory();
	}
	public static Session openSession(){
		return sessionFactory.openSession();
	}
	public static Session getCurrentSession(){
		Session session=threadLocal.get();
		if(session==null){
			session=sessionFactory.openSession();
			threadLocal.set(session);
		}
		return session;
	}
}
