package com.gzeic.test;

public class Main {
	int num;
	int studentId;
	String name;

	public Main(int num, int studentId, String name) {
		this.num = num;
		this.name = name;
		this.studentId = studentId;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}