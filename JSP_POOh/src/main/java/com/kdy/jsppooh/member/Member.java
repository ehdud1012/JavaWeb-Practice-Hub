package com.kdy.jsppooh.member;

import java.util.Date;

public class Member {
	private String id;
	private String pw;
	private Date birthday;
	private String photo;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String pw, Date birthday, String photo) {
		super();
		this.id = id;
		this.pw = pw;
		this.birthday = birthday;
		this.photo = photo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
