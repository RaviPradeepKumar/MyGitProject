package com.infotech.client;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.infotech.entities.Employee;
import com.infotech.model.Address;
import com.infotech.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			createEmployee(session);
		}//try
		catch(HibernateException e) {
			e.printStackTrace();
		}

	}

	private static void createEmployee(Session session) {
		session.beginTransaction();
     	Integer id = (Integer) session.save(getEmployee());
		System.out.println("Employee is saved with id :"+id);
		session.getTransaction().commit();
	}

	public static Employee getEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeName("karthik");
		employee.setEmail("karhik@gmail.com");
		employee.setSalary(50000.0);
		employee.setDoj(new Date());
		
		Address address = new Address();
		address.setCity("RJY");
		address.setState("ap");
		address.setPincode(43302);
		address.setCountry("India");
		
		Address address2 = new Address();
		address2.setCity("KKD");
		address2.setState("ap");
		address2.setPincode(5893);
		address2.setCountry("India");
		
		employee.getAddressList().add(address);
		employee.getAddressList().add(address2);
		return employee;
	}
}
