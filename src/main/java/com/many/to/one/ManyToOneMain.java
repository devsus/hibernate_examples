package com.many.to.one;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.codelearn.persistence.HibernateUtil;

public class ManyToOneMain {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Employee e1=new Employee();    
	    e1.setName("Ravi Malik");    
	    e1.setEmail("ravi@gmail.com");    
	      
	    Employee e2=new Employee();  
	    e2.setName("Anuj Verma");  
	    e2.setEmail("anuj@gmail.com");  
	    
	    Address address1=new Address();    
	    address1.setAddressLine1("G-13,Sector 3");    
	    address1.setCity("Noida");    
	    address1.setState("UP");    
	    address1.setCountry("India");    
	    address1.setPincode(201301);    
	    
	    //multiple employee can have same address
	    e1.setAddress(address1);    
	    e2.setAddress(address1); 
	    
	    session.persist(e1);
	    session.persist(e2);
	    
	    transaction.commit();
		
		
	}

}
