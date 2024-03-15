package com.prowings.JDBC_Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Update operation using int executeUpdate();
 */

public class JDBC_Connection2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_data", "root", "Guru5798@");

		Statement stmt = (Statement) con.createStatement();

		int res = stmt.executeUpdate("insert into student values(7,'hina','c++',107)");
		//int res = stmt.executeUpdate("delete from student where id=7");

		if (res > 0)
			System.out.println("DB updated....rows affected are"+res);

	}

}
