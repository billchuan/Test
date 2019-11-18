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
			System.out.println("\t新闻管理系统，选择功能");
			System.out.println("1、添加新闻");
			System.out.println("2、查看所有新闻");
			System.out.println("3、根据编号查找新闻");
			System.out.println("4、根据编号删除新闻");
			System.out.println("5、根据编号修改新闻");
			System.out.println("6、退出系统");
			System.out.println("请选择:");
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

					System.out.print("请输入新闻编号：");

					Integer newsId = sc.nextInt();

					manager.queryNwesById(newsId);

					break;

				case 4:

					System.out.print("请输入新闻编号:");

					Integer deleteId = sc.nextInt();

					manager.deleteNewsById(deleteId);

					break;

				case 5:

					System.out.print("请输入新闻编号:");

					Integer updateId = sc.nextInt();

					manager.updateNewsByid(updateId);

					break;

				case 6:

					System.out.print("正常退出系统");

					flag = false;

					break;

				}

			} else {

				System.out.println("输入的选择不再权限范围内");

			}

		} while (flag);

	}

	public void addNews() {

		Scanner sc = new Scanner(System.in);

		System.out.print("请输入新闻编号");

		String newsId = sc.next();

		System.out.print("请输入新闻标题");

		String newsTitle = sc.next();

		System.out.print("请输入新闻内容");

		String newsContent = sc.next();

		System.out.print("请输入新闻作者");

		String newsAuthor = sc.next();

		System.out.print("请输入新闻备注");

		String newsRemark = sc.next();

		News news = new News(Integer.parseInt(newsId), newsTitle, newsContent, newsAuthor, new Date(), newsRemark);

		newsList.add(news);

	}

	public void queryNews() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyy/MM/dd");

		System.out.println("编号\t标题\t内容\t时间\t\t\t作者\t备注");

		for (News news : newsList) {

			System.out.println(news.getNewsid() + "\t" + news.getNewsTitle() + "\t" + news.getContent() + "\t"
					+ sdf.format(news.getSdata()) + "\t" + news.getAuthor() + "\t" + news.getDescription() + "\t");

		}

	}

	public void queryNwesById(Integer newsId) {

		boolean flag = false;

		SimpleDateFormat sdf = new SimpleDateFormat("yyy/MM/dd");

		System.out.println("编号\t标题\t内容\t时间\t\t\t作者\t备注");

		for (News news : newsList) {

			if (news.getNewsid() == newsId) {

				System.out.println(news.getNewsid() + "\t" + news.getNewsTitle() + "\t" + news.getContent() + "\t"
						+ sdf.format(news.getSdata()) + "\t" + news.getAuthor() + "\t" + news.getDescription() + "\t");

				flag = true;

				break;

			}

		}

		if (flag == false) {

			System.out.println("未查找到符合条件的数据");

		}

	}

	public void deleteNewsById(Integer newsId) {

		boolean flag = false;

		for (News news : newsList) {

			if (news.getNewsid() == newsId) {

				newsList.remove(news);

				flag = true;

				System.out.println("删除成功");

				break;

			}

		}

		if (flag == false) {

			System.out.println("未查找到需要删除的数据");

		}

	}

	public void updateNewsByid(Integer newsId) {

		Scanner sc = new Scanner(System.in);

		boolean flag = false;

		for (News news : newsList) {

			if (news.getNewsid() == newsId) {

				System.out.println("请输入新闻标题");

				String newsTitle = sc.next();

				System.out.println("请输入新闻内容");

				String newsContent = new Scanner(System.in).next();

				news.setNewsTitle(newsTitle);

				news.setContent(newsContent);

				flag = true;

				System.out.println("修改成功");

				break;

			}

		}

		if (flag == false) {

			System.out.println("修改失败");

		}

	}
}
