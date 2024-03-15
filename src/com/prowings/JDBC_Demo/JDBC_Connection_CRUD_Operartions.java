
package com.prowings.JDBC_Demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Create,Read,Update,Delete(CRUD) operation using int executeUpdate()and
 * ResultInt ;
 */

public class JDBC_Connection_CRUD_Operartions {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_data", "root", "Guru5798@");

		Statement stmt = con.createStatement();

		// int res = stmt.executeUpdate("insert into student
		// values(7,'hina','c++',107)");//updating a table in DB

		int res = stmt.executeUpdate("delete from student where id=7");// deleting row from a table

		if (res > 0)
			System.out.println("DB updated....rows affected are" + res);

	}

//+++++++++++++++++++++++++++ Create Operation++++++++++++++++++++++++++++++
	public int createStudent(Student s) {
		int res = 0;
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_data", "root", "Guru5798@");

		//	Statement stmt = con.createStatement();
			
			PreparedStatement stmt =con.prepareStatement("insert into student values(?,?,?,?)");

			stmt.setInt(1, s.getId());
			stmt.setString(2,s.getName());
			stmt.setString(3, s.getSubject());
			stmt.setInt(4, s.getRollNum());

			//int rs = stmt.executeUpdate("insert into student values(" + id + "," + "'" + name + "'" + "," + "'" + sub
			//		+ "'" + "," + rn + ")");

			res = stmt.executeUpdate();
			
			if (res > 0) {
				System.out.println("Student object created on DB...." + s.toString());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return res;

	}

//++++++++++++++++++++++++++ Read Operation+++++++++++++++++++++++++++++++++++++++++++++++
	public Student getStudent(int id) {
		Student s = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_data", "root", "Guru5798@");

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("Select * from student");
			while (rs.next()) {

				if (rs.getInt(1) == id) {
					s = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}

		return s;

	}

	// ++++++++++++++++++++++++++ Update Operation
	public boolean updateStudent(Student updatedStudent) {

		boolean res = false;
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_data", "root",
				"Guru5798@")) {

			Statement stmt = con.createStatement();
			int id = updatedStudent.getId();
			String nm1 = updatedStudent.getName();
			String sb = updatedStudent.getSubject();
			int rn = updatedStudent.getRollNum();

			int rs = stmt.executeUpdate(
					"insert into student values(" + id + "," + "'" + nm1 + "'" + "," + "'" + sb + "'" + "," + rn + ")");

			if (rs > 0) {
				res = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	// +++++++++++++++++++++++++ Delete Operation
	// +++++++++++++++++++++++++++++++++++++++++++++++++++
	public boolean deleteStudent(int id) {
		boolean res = false;

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_data", "root",
				"Guru5798@")) {

			//Statement stmt = con.createStatement();
			
			PreparedStatement stmt =con.prepareStatement("delete from student where id=?");
			
			stmt.setInt(1, id);

//			ResultSet rs= stmt.executeQuery("select * from student");
//			
//			while(rs.next()) {
//				if(rs.getInt(1)==id) {
			int r = stmt.executeUpdate();
			if (r > 0)
				res = true;
//				}
//			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
//------------------------------------List of Objects from DB

	public List<Student> getAllStudents() {
		List<Student> l = new ArrayList<Student>();

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_data", "root",
				"Guru5798@")) {

			Statement stm = con.createStatement();

			ResultSet rs = stm.executeQuery("select * from student");
			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setSubject(rs.getString(3));
				s.setRollNum(rs.getInt(4));
				l.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return l;

	}
}
