package com.gzeic.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
	static List<Main> mainList = new ArrayList<Main>();
	static StudentManager manager = new StudentManager();
	public static void main(String[] args) {
		boolean flag = true;
		Main user=new Main(1, 21500500, "王某");
		mainList.add(user);
		do {
			System.out.println("学生管理系统，选择功能");
			System.out.println("1:显示数据");
			System.out.println("2:修改数据");
			System.out.println("3:增加数据");
			System.out.println("4:删除数据");
			System.out.println("0:退出系统");
			System.out.print("请选择你需要操作的功能:");
			Scanner sc = new Scanner(System.in);
			int userselect = sc.nextInt();
			if (userselect >= 0 && userselect <= 4) {
				switch (userselect) {
				case 1:
					System.out.println("-----------------------显示------------------------------");
					manager.queryStudents();
					System.out.println("-----------------------退出显示-------------------------");
					break;
				case 2:
					System.out.println("-----------------------修改------------------------------");
					manager.queryStudents();
					manager.updateStudentDate();
					System.out.println("-----------------------退出修改-------------------------");
					break;
				case 3:
					System.out.println("-----------------------增加--------------------------");
					manager.addStudentDate();
					System.out.println("-----------------------退出增加-------------------------");
					break;
				case 4:
					System.out.println("-----------------------删除---------------------------");
					manager.queryStudents();
					manager.deleteStudentDate();
					System.out.println("-----------------------退出删除-------------------------");
					break;
				case 0:
					System.out.println("正常退出系统");
					flag = false;
					break;
				}
			} else {
				System.out.println("请输入有效数字(0-4)");
			}

		} while (flag);

	}

	public void deleteStudentDate() {
		Scanner sc = new Scanner(System.in);
		System.out.println("0退出删除");
		for (Main main : mainList) {
			System.out.print("请选择你要删除的数据:");
			int input = sc.nextInt();
			if (main.getNum() == input) {
				System.out.print("请问是否删除序号为:" + input + "学号为:" + main.studentId + "姓名为:" + main.name + "的数据(y/n):");
			} else {
				System.out.println("未找到数据");
			}
			String select = sc.next();
			if (select.equals("y")) {
				mainList.remove(main);
				System.out.println("该条数据被删除");
				break;
			} else if (select.equals("n")) {
				System.out.println("数据未被修改");
				break;
			}

		}
	}

	public void addStudentDate() {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入序号:");
		String num = sc.next();
		System.out.print("请输入学号:");
		int studentId = sc.nextInt();
		System.out.print("请输入学生姓名:");
		String studentName = sc.next();
		Main main = new Main(Integer.parseInt(num), studentId, studentName);

		mainList.add(main);
	}

	public void updateStudentDate() {
		Scanner sc = new Scanner(System.in);
		for (Main main : mainList) {
			System.out.print("请选择需要修改的数据:");
			int updateId = sc.nextInt();
			if (main.getNum() == updateId) {
				System.out.println("--------------------进入修改内容----------------------");
				System.out.println("可以修改以下内容：\n1：学号\n2：姓名\n0：退出修改");
				System.out.print("请输入要修改的序号:");
				int input = sc.nextInt();
				switch (input) {
				case 1:
					System.out.print("请输入新数据:");
					int newStudentId = sc.nextInt();
					main.setStudentId(newStudentId);
					break;
				case 2:
					System.out.print("请输入新数据:");
					String newName = sc.next();
					main.setName(newName);
					break;
				case 0:
					System.out.println("0条数据被修改");
					break;
				}
				break;

			} else {
				System.out.println("未找到数据");
			}
		}
	}

	public void queryStudents() {

		System.out.println("序号\t学号\t姓名");

		for (Main main : mainList) {

			System.out.println(main.getNum() + "\t" + main.getStudentId() + "\t" + main.getName() + "\t");

		}

	}

}
