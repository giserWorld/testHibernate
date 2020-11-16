package considerKnowledge;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.domain.Employee;
import com.util.HibernateUtil;

/**********************Query接口**********************
 *1.通过query接口我们可以完成更加复杂的查询任务。
 *2.
 **/
public class Interface_Query {
	public static void main(String[] args) {
		Session session=null;
		try{
			session = HibernateUtil.openSession();
			Transaction transaction = session.beginTransaction();
			//Query查询
			Query query=session.createQuery("from Employee where name='小红'");//hql语句
			//通过list方法获取查询结果,这个list会自动地封装成对应的domain对象
			List<Employee> list = query.list();
			for(Employee employee:list){
				System.out.println(employee.getName());
			}
			transaction.commit();
		}
		finally{
			if(session!=null){
				session.close();
			}
		}
	}
}
