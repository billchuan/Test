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
	System.out.println("ѧ������ϵͳ��ѡ����");
	System.out.println("1:��ʾ����");
	System.out.println("2:�޸�����");
	System.out.println("3:��������");
	System.out.println("4:ɾ������");
	System.out.println("0:�˳�ϵͳ");
	System.out.println("��ѡ������Ҫ�����Ĺ���:");
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
			System.out.println("�����˳�ϵͳ");
			flag=false;
			break;
		}
	}else{
		System.out.println("��������Ч����(0-4)");
	}
		
	}while(flag);
}

public void deleteStudentDate() {
	
	
}

public void addStudentDate() {
Scanner sc=new Scanner(System.in);
System.out.print("���������");
String num=sc.next();
System.out.print("������ѧ��");
String studentId=sc.next();
System.out.print("������ѧ������");
String studentName=sc.next();
	
}

public void updateStudentDate() {
	
	
}

public void queryStudents() {
System.out.println("���\tѧ��\t����");	
for(Main main:mainList){
	
}
	
}
}
