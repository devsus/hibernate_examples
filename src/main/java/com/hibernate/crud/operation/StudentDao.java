package com.hibernate.crud.operation;

import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Session;

import in.codelearn.persistence.HibernateUtil;

public class StudentDao implements IStudentDao{
	@Override
	public void saveStudent(Student student) {
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(student);
			
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
		}
		
		
	}
	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Student getStudentById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void deleteStudent(long id) {
		// TODO Auto-generated method stub
		
	}

}
