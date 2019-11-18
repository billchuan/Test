package com.gzeic.test;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;

import java.util.Scanner;

import java.util.concurrent.ScheduledExecutorService;

public class Newsmanager {

	List<News> newsList = new ArrayList<News>();

	public static void main(String[] args) {

		Newsmanager manager = new Newsmanager();

		boolean flag = true;

		do {
			System.out.println("\t���Ź���ϵͳ��ѡ����");
			System.out.println("1���������");
			System.out.println("2���鿴��������");
			System.out.println("3�����ݱ�Ų�������");
			System.out.println("4�����ݱ��ɾ������");
			System.out.println("5�����ݱ���޸�����");
			System.out.println("6���˳�ϵͳ");
			System.out.println("��ѡ��:");
			Scanner sc = new Scanner(System.in);

			int userselect = sc.nextInt();

			if (userselect >= 1 && userselect <= 6) {

				switch (userselect) {

				case 1:

					manager.addNews();

					break;

				case 2:

					manager.queryNews();

					break;

				case 3:

					System.out.print("���������ű�ţ�");

					Integer newsId = sc.nextInt();

					manager.queryNwesById(newsId);

					break;

				case 4:

					System.out.print("���������ű��:");

					Integer deleteId = sc.nextInt();

					manager.deleteNewsById(deleteId);

					break;

				case 5:

					System.out.print("���������ű��:");

					Integer updateId = sc.nextInt();

					manager.updateNewsByid(updateId);

					break;

				case 6:

					System.out.print("�����˳�ϵͳ");

					flag = false;

					break;

				}

			} else {

				System.out.println("�����ѡ����Ȩ�޷�Χ��");

			}

		} while (flag);

	}

	public void addNews() {

		Scanner sc = new Scanner(System.in);

		System.out.print("���������ű��");

		String newsId = sc.next();

		System.out.print("���������ű���");

		String newsTitle = sc.next();

		System.out.print("��������������");

		String newsContent = sc.next();

		System.out.print("��������������");

		String newsAuthor = sc.next();

		System.out.print("���������ű�ע");

		String newsRemark = sc.next();

		News news = new News(Integer.parseInt(newsId), newsTitle, newsContent, newsAuthor, new Date(), newsRemark);

		newsList.add(news);

	}

	public void queryNews() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyy/MM/dd");

		System.out.println("���\t����\t����\tʱ��\t\t\t����\t��ע");

		for (News news : newsList) {

			System.out.println(news.getNewsid() + "\t" + news.getNewsTitle() + "\t" + news.getContent() + "\t"
					+ sdf.format(news.getSdata()) + "\t" + news.getAuthor() + "\t" + news.getDescription() + "\t");

		}

	}

	public void queryNwesById(Integer newsId) {

		boolean flag = false;

		SimpleDateFormat sdf = new SimpleDateFormat("yyy/MM/dd");

		System.out.println("���\t����\t����\tʱ��\t\t\t����\t��ע");

		for (News news : newsList) {

			if (news.getNewsid() == newsId) {

				System.out.println(news.getNewsid() + "\t" + news.getNewsTitle() + "\t" + news.getContent() + "\t"
						+ sdf.format(news.getSdata()) + "\t" + news.getAuthor() + "\t" + news.getDescription() + "\t");

				flag = true;

				break;

			}

		}

		if (flag == false) {

			System.out.println("δ���ҵ���������������");

		}

	}

	public void deleteNewsById(Integer newsId) {

		boolean flag = false;

		for (News news : newsList) {

			if (news.getNewsid() == newsId) {

				newsList.remove(news);

				flag = true;

				System.out.println("ɾ���ɹ�");

				break;

			}

		}

		if (flag == false) {

			System.out.println("δ���ҵ���Ҫɾ��������");

		}

	}

	public void updateNewsByid(Integer newsId) {

		Scanner sc = new Scanner(System.in);

		boolean flag = false;

		for (News news : newsList) {

			if (news.getNewsid() == newsId) {

				System.out.println("���������ű���");

				String newsTitle = sc.next();

				System.out.println("��������������");

				String newsContent = new Scanner(System.in).next();

				news.setNewsTitle(newsTitle);

				news.setContent(newsContent);

				flag = true;

				System.out.println("�޸ĳɹ�");

				break;

			}

		}

		if (flag == false) {

			System.out.println("�޸�ʧ��");

		}

	}
}
