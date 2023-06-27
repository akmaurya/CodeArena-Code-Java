package sample.client;

import java.util.Collection;
import java.util.LinkedList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import sample.model.Employee;

public class HibernateTest {

	public static void main(String ar[])
	{
		/*Employee emp = new Employee();
		emp.setID(3);
		emp.setName("First User");
		System.out.println(emp.getName());
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		System.out.println(emp.getName());
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();*/
		
		LinkedList l = new LinkedList();
		 l.add(null);
		 l.add(null);
		 l.add("arvind");
		 l.add(1);
		 System.out.println(l);
	}
}
