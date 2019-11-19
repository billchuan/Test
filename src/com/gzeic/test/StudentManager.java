package com.gzeic.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
	static List<Main> mainList = new ArrayList<Main>();
	static StudentManager manager = new StudentManager();
	public static void main(String[] args) {
		boolean flag = true;
		Main user=new Main(1, 21500500, "��ĳ");
		mainList.add(user);
		do {
			System.out.println("ѧ������ϵͳ��ѡ����");
			System.out.println("1:��ʾ����");
			System.out.println("2:�޸�����");
			System.out.println("3:��������");
			System.out.println("4:ɾ������");
			System.out.println("0:�˳�ϵͳ");
			System.out.print("��ѡ������Ҫ�����Ĺ���:");
			Scanner sc = new Scanner(System.in);
			int userselect = sc.nextInt();
			if (userselect >= 0 && userselect <= 4) {
				switch (userselect) {
				case 1:
					System.out.println("-----------------------��ʾ------------------------------");
					manager.queryStudents();
					System.out.println("-----------------------�˳���ʾ-------------------------");
					break;
				case 2:
					System.out.println("-----------------------�޸�------------------------------");
					manager.queryStudents();
					manager.updateStudentDate();
					System.out.println("-----------------------�˳��޸�-------------------------");
					break;
				case 3:
					System.out.println("-----------------------����--------------------------");
					manager.addStudentDate();
					System.out.println("-----------------------�˳�����-------------------------");
					break;
				case 4:
					System.out.println("-----------------------ɾ��---------------------------");
					manager.queryStudents();
					manager.deleteStudentDate();
					System.out.println("-----------------------�˳�ɾ��-------------------------");
					break;
				case 0:
					System.out.println("�����˳�ϵͳ");
					flag = false;
					break;
				}
			} else {
				System.out.println("��������Ч����(0-4)");
			}

		} while (flag);

	}

	public void deleteStudentDate() {
		Scanner sc = new Scanner(System.in);
		System.out.println("0�˳�ɾ��");
		for (Main main : mainList) {
			System.out.print("��ѡ����Ҫɾ��������:");
			int input = sc.nextInt();
			if (main.getNum() == input) {
				System.out.print("�����Ƿ�ɾ�����Ϊ:" + input + "ѧ��Ϊ:" + main.studentId + "����Ϊ:" + main.name + "������(y/n):");
			} else {
				System.out.println("δ�ҵ�����");
			}
			String select = sc.next();
			if (select.equals("y")) {
				mainList.remove(main);
				System.out.println("�������ݱ�ɾ��");
				break;
			} else if (select.equals("n")) {
				System.out.println("����δ���޸�");
				break;
			}

		}
	}

	public void addStudentDate() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���������:");
		String num = sc.next();
		System.out.print("������ѧ��:");
		int studentId = sc.nextInt();
		System.out.print("������ѧ������:");
		String studentName = sc.next();
		Main main = new Main(Integer.parseInt(num), studentId, studentName);

		mainList.add(main);
	}

	public void updateStudentDate() {
		Scanner sc = new Scanner(System.in);
		for (Main main : mainList) {
			System.out.print("��ѡ����Ҫ�޸ĵ�����:");
			int updateId = sc.nextInt();
			if (main.getNum() == updateId) {
				System.out.println("--------------------�����޸�����----------------------");
				System.out.println("�����޸��������ݣ�\n1��ѧ��\n2������\n0���˳��޸�");
				System.out.print("������Ҫ�޸ĵ����:");
				int input = sc.nextInt();
				switch (input) {
				case 1:
					System.out.print("������������:");
					int newStudentId = sc.nextInt();
					main.setStudentId(newStudentId);
					break;
				case 2:
					System.out.print("������������:");
					String newName = sc.next();
					main.setName(newName);
					break;
				case 0:
					System.out.println("0�����ݱ��޸�");
					break;
				}
				break;

			} else {
				System.out.println("δ�ҵ�����");
			}
		}
	}

	public void queryStudents() {

		System.out.println("���\tѧ��\t����");

		for (Main main : mainList) {

			System.out.println(main.getNum() + "\t" + main.getStudentId() + "\t" + main.getName() + "\t");

		}

	}

}
