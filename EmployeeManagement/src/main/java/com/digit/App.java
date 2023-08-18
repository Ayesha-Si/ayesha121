package com.digit;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.digit.entity.Employee;

public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
//        Employee employee=new Employee("Ashish",788,45000);//trancient object getting converted into persistent state
//        session.save(employee);//db identifier
//        System.out.println("record inserted");
        
//        Employee emp  =session.get(Employee.class, 6487);
//        System.out.println(emp);
        
        
        Employee emp1=session.get(Employee.class, 9008);
        emp1.setEmployeeName("Roy");
        session.saveOrUpdate(emp1);
        transaction.commit();
        System.out.println("record updated");
        
        List<Employee> emplist=session.createQuery("from Employee").list();
        System.out.println("All records of employee table");
        for(Employee e:emplist)
        	System.out.println(e);
        
        
        
        
       
        session.close();
        sessionFactory.close();
        
    }
}
