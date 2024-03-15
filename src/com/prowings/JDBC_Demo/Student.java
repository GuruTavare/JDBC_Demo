package com.prowings.JDBC_Demo;

public class Student {
	private int id;
	private String name;
	private String subject;
	private int rollNum;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, String subject, int rollNum) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.rollNum = rollNum;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSubject() {
		return subject;
	}

	public int getRollNum() {
		return rollNum;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", subject=" + subject + ", rollNum=" + rollNum + "]";
	}

}
