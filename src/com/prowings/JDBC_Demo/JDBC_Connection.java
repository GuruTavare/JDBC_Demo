package com.prowings.JDBC_Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Query Operations using executeQuery();
 */
public class JDBC_Connection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_data", "root", "Guru5798@");

		Statement stmt = (Statement) con.createStatement();

		ResultSet res = stmt.executeQuery("select * from student");
// reading the database through Student object
		while (res.next()) {

			Student s = new Student();

			s.setId(res.getInt(1));
			s.setName(res.getString(2));
			s.setSubject(res.getString(3));
			s.setRollNum(res.getInt(4));
			System.out.println(s);

		}
	}
} 