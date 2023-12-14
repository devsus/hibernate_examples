package com.hibernate.crud.operation;

public class CrudMainApplication {

	public static void main(String[] args) {
		IStudentDao iStudentDao = new StudentDao();
		// test saveStudent
        Student student = new Student("Ramesh", "Fadatare", "ramesh@gmail.com");
        iStudentDao.saveStudent(student);

	}

}
