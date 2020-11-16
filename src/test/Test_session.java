package test;

import org.hibernate.Session;

import com.util.HibernateUtil;

public class Test_session {
	public static void main(String[] args) {
		//新的session
		/*Session session1 = HibernateUtil.openSession();
		Session session2 = HibernateUtil.openSession();*/
		
		//线程关联的session
		Session session1 = HibernateUtil.getCurrentSession();
		Session session2 = HibernateUtil.getCurrentSession();
		System.out.println(session1.hashCode());
		System.out.println(session2.hashCode());
	}
}
