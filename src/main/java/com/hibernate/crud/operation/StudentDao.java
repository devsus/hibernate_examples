package com.hibernate.crud.operation;

import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Session;

import in.codelearn.persistence.HibernateUtil;

public class StudentDao implements IStudentDao {
	@Override
	public void saveStudent(Student student) {
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(student);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

	@Override
	public void updateStudent(Student student) {
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();

			// save student object
			session.saveOrUpdate(student);

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	@Override
	public List<Student> getAllStudents() {
		Transaction transaction = null;
		List<Student> students = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			// get students
			students = session.createQuery("from Student").list();
			// student = session.load(Student.class, id);
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return students;
	}

	@Override
	public Student getStudentById(long id) {
		Transaction transaction = null;
		Student student = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();

			// get student object
			// student = (Student) session.get(Student.class, id);
			student = (Student) session.load(Student.class, id);
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return student;
	}

	@Override
	public void deleteStudent(long id) {
		Transaction transaction = null;
		Student student = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start the transaction
			transaction = session.beginTransaction();

			student = (Student) session.get(Student.class, id);
			// get student object
			session.delete(student);
			// student = session.load(Student.class, id);
			// commit the transaction
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

}
