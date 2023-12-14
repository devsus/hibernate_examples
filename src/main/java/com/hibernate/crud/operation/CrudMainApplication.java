package com.hibernate.crud.operation;

import java.util.List;

public class CrudMainApplication {

	public static void main(String[] args) {
		IStudentDao iStudentDao = new StudentDao();
		// test saveStudent
        Student student = new Student("Ram", "Fadat", "ramesh@gmail.com");
        iStudentDao.saveStudent(student);
        
        // test updateStudent
        student.setFirstName("Ram");
        iStudentDao.updateStudent(student);
     // test getStudentById
        Student student2 = iStudentDao.getStudentById(student.getId());
        System.out.println(student2);
        
     // test getAllStudents
        List< Student > students = iStudentDao.getAllStudents();
        students.forEach(student1 -> System.out.println(student1.getId()+"  : "+student1.getFirstName()));
        
     // test deleteStudent
        iStudentDao.deleteStudent(student.getId());

	}

}
