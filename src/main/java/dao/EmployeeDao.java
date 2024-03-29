package dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import dto.Employee;

public class EmployeeDao 
{
	public Session getSession()
	{
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		return session;
	}
	public void saveEmployee(Employee employee)
	{
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		session.save(employee);
		transaction.commit();
	}
	public void updateEmployee(int id,Employee employee)
	{
		Session session=getSession();
		Employee dbEmployee=session.find(Employee.class,id);
		if(dbEmployee!=null)
		{
			session.getTransaction().begin();
			employee.setEmpId(id);
			session.merge(employee);
			session.getTransaction().commit();
		}
		else
		{
			System.out.println("Invalid Employee Id");
		}
		
	}
	public void deleteEmployee(int id)
	{
		Session session=getSession();
		Employee dbEmployee=session.find(Employee.class,id);
		if(dbEmployee!=null)
		{
			session.getTransaction().begin();
			session.remove(dbEmployee);
			session.getTransaction().commit();
		}
		else
		{
			System.out.println("Id Not Present");
		}
	}
	public void displayEmployee(int id)
	{
		Session session=getSession();
		Employee dbEmployee=session.find(Employee.class,id);
		if(dbEmployee!=null)
		{
			System.out.println(dbEmployee);
		}
		else
		{
			System.out.println("Id Not Present");
		}
	}
	public void displayAll()
	{
		Session session=getSession();
		Query<Employee>query=session.createQuery("SELECT E FROM Employee E");
		List<Employee>employees=query.getResultList();
		Iterator<Employee>iterator=employees.iterator();
		while (iterator.hasNext()) 
		{
			System.out.println("--------------------------------------------------------------------------------------------------------------------");
			System.out.println(iterator.next());
			System.out.println("---------------------------------------------------------------------------------------------------------------------\n");
		}
	}
	
}
