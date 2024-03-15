package com.prowings.JDBC_Demo;

import java.util.List;

public class Test_JDBC_CRUD_Operation {

	public static void main(String[] args) {
//	Student s = new Student(5, "sam", "C#", 107);

		JDBC_Connection_CRUD_Operartions j = new JDBC_Connection_CRUD_Operartions();
//___________________-------------Create
//		if (j.createStudent(s) > 0) {
//			System.out.println("Object added successfully!!!");
//		}
//---------------------------Read
//		Student s1 = j.getStudent(5);
//
//		System.out.println(s1);
//---------------------Update		
//		Student s= new Student(7, "sam", "C#", 107);
//		Student s= new Student(8, "pam", "Hindi", 108);
//		boolean res=j.updateStudent(s);
//		if(res)
//			System.out.println("DB Updated successfully!!!....with Object.."+s);
		
//		-----------------------delete
		
		boolean rs = j.deleteStudent(5);
		
		if(rs)
			System.out.println("In DB delete operation executed.. ");
//		-----------------------List<Student>
		
	//	List<Student> s= j.getAllStudents();
	//	System.out.println(s);
	}

}
