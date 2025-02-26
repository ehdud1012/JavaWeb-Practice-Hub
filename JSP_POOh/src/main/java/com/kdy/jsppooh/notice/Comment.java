package com.kdy.jsppooh.notice;

import java.util.Date;

public class Comment {
	private int no;
	private String txt;
	private Date date;
	private String writer;
	private int notionNo;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(int no, String txt, Date date, String writer, int notionNo) {
		super();
		this.no = no;
		this.txt = txt;
		this.date = date;
		this.writer = writer;
		this.notionNo = notionNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getNotionNo() {
		return notionNo;
	}

	public void setNotionNo(int notionNo) {
		this.notionNo = notionNo;
	}
}
