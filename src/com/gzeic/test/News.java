package com.gzeic.test;

import java.util.Date;

public class News {

	private Integer newsid;

	private String newsTitle;

	private String content;

	private String author;

	private Date sdata;

	private String Description;

	public News() {

	}

	public News(Integer newsid, String newsTitle, String content, String author, Date sdata, String description) {

		this.newsid = newsid;

		this.newsTitle = newsTitle;

		this.content = content;

		this.author = author;

		this.sdata = sdata;

		Description = description;

	}

	public Integer getNewsid() {

		return newsid;

	}

	public void setNewsid(Integer newsid) {

		this.newsid = newsid;

	}

	public String getNewsTitle() {

		return newsTitle;

	}

	public void setNewsTitle(String newsTitle) {

		this.newsTitle = newsTitle;

	}

	public String getContent() {

		return content;

	}

	public void setContent(String content) {

		this.content = content;

	}

	public String getAuthor() {

		return author;

	}

	public void setAuthor(String author) {

		this.author = author;

	}

	public Date getSdata() {

		return sdata;

	}

	public void setSdata(Date sdata) {

		this.sdata = sdata;

	}

	public String getDescription() {

		return Description;

	}

	public void setDescription(String description) {

		Description = description;

	}

}
