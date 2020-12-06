package test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.domain.Employee;
import com.util.MySessionFactory;
//测试类
public class TestMain {
	public static void main(String[] args) {
		sessionAPI_save();//api_save();
		//sessionAPI_update();//api_update();
	}

	//2.更新数据(update)
	private static void sessionAPI_update() {
		SessionFactory sessionFactory=MySessionFactory.getSessionFactory();//获取sessionFactory
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Employee obj = (Employee) session.load(Employee.class,1);//获取实体对象
		obj.setName("更新数据name2");
		ts.commit();
		session.close();
	}

	
	//1.插入数据(insert)
	private static void sessionAPI_save() {
		//1.读取hibernate配置文件(从hibernate.cfg.xml文件中自动读取配置)
		Configuration config=new Configuration().configure("hibernate.cfg.xml");
		
		//2.获取SessionFactory工厂对象(从hibernate配置中构建SessionFactory对象)
		SessionFactory sessionFactory=config.buildSessionFactory();
		//System.out.println(sessionFactory);
		
		//3.获取session对象(包含操作数据库的api)
		Session sqlSession=sessionFactory.openSession();
		//获取事务管理,否则不能将操作保存于数据库
		Transaction transaction =sqlSession.beginTransaction();
		
		//创建一个java对象
		Employee empolyee1=new Employee();
		//empolyee1.setName("雇员1");
		//empolyee1.setEmail("602574436@qq.com");
		//empolyee1.setHiredate(new Date());
		
		//hibernate封装的"insert"的sql接口
		sqlSession.save(empolyee1);
		transaction.commit();//事务提交到数据库
		sqlSession.close();//关闭数据库连接
	}
}
