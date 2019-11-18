package com.gzeic.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
	List<Main> mainList = new ArrayList<Main>();

public static void main(String[] args) {
	StudentManager manager=new StudentManager();
	boolean flag=true;
	do{
	System.out.println("学生管理系统，选择功能");
	System.out.println("1:显示数据");
	System.out.println("2:修改数据");
	System.out.println("3:增加数据");
	System.out.println("4:删除数据");
	System.out.println("0:退出系统");
	System.out.println("请选择你需要操作的功能:");
	Scanner sc=new Scanner(System.in);
	int userselect=sc.nextInt();
	if(userselect>=0&&userselect<=4){
		switch(userselect){
		case 1:
			manager.queryStudents();
			break;
		case 2:
			manager.updateStudentDate();
			break;
		case 3:
			manager.addStudentDate();
			break;
		case 4:
			manager.deleteStudentDate();
			break;
		case 0:
			System.out.println("正常退出系统");
			flag=false;
			break;
		}
	}else{
		System.out.println("请输入有效数字(0-4)");
	}
		
	}while(flag);
}

public void deleteStudentDate() {
	
	
}

public void addStudentDate() {
Scanner sc=new Scanner(System.in);
System.out.print("请输入序号");
String num=sc.next();
System.out.print("请输入学号");
String studentId=sc.next();
System.out.print("请输入学生姓名");
String studentName=sc.next();
	
}

public void updateStudentDate() {
	
	
}

public void queryStudents() {
System.out.println("序号\t学号\t姓名");	
for(Main main:mainList){
	
}
	
}
}
