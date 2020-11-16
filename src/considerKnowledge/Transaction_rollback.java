package considerKnowledge;

import javax.management.RuntimeErrorException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.domain.Employee;
import com.util.MySessionFactory;

/**********************事务回滚**********************
 *1.
 **/
public class Transaction_rollback {
	public static void main(String[] args) {
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction ts=null;
		try {
			ts=session.beginTransaction();
			Employee obj = (Employee)session.load(Employee.class,1);
			obj.setName("小熊");
			int i=9/0;
			ts.commit();
		} catch (Exception e) {
			if(ts!=null){
				ts.rollback();//事务回滚
			}
			throw new RuntimeException(e.getMessage());//抛出异常
			
		}
		finally{
			if(session!=null&&session.isOpen()){
				session.close();//关闭会话
			}
		}
	}
}
