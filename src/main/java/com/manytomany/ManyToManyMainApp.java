package com.manytomany;

import org.hibernate.Session;

import in.codelearn.persistence.HibernateUtil;

public class ManyToManyMainApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Create an employee
        Employeem employee = new Employeem();
        employee.setFirstName("Ramesh");
        employee.setLastName("Fadatare");

       // Create project1
        Project project = new Project();
        project.setTitle("Employee Management System");

        // Create project2
        Project project1 = new Project();
       project1.setTitle("Content Management System");

       // employee can work on two projects, Add project references in the employee
       employee.getProjects().add(project);
       employee.getProjects().add(project1);

        // Add employee reference in the projects
       project.getEmployees().add(employee);
       project1.getEmployees().add(employee);

       session.persist(employee);

       session.getTransaction().commit();

	}

}
