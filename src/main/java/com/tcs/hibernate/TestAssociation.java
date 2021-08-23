package com.tcs.hibernate;

import org.hibernate.Session;

import com.tcs.entity.AccountEntity;
import com.tcs.entity.EmployeeEntity;

public class TestAssociation {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		AccountEntity account = new AccountEntity();
		account.setAccountNumber("123-345-67890");

		// Add new Employee object
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmail("demo-user@mail.com");
		emp.setFirstName("demo");
		emp.setLastName("user");

		// Save Account
		session.save(account);
		// Save Employee
		emp.setAccount(account);
		session.save(emp);

		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}
}
