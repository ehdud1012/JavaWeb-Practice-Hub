package com.kdy.sep10ct.wc;

public class WeatherInfo {
	private String hour;
	private String temp;
	private String wfKor;
	private String img;
	
	
	public WeatherInfo() {
		// TODO Auto-generated constructor stub
	}


	public WeatherInfo(String hour, String temp, String wfKor, String img) {
		super();
		this.hour = hour;
		this.temp = temp;
		this.wfKor = wfKor;
		this.img = img;
	}


	public String getHour() {
		return hour;
	}


	public void setHour(String hour) {
		this.hour = hour;
	}


	public String getTemp() {
		return temp;
	}


	public void setTemp(String temp) {
		this.temp = temp;
	}


	public String getWfKor() {
		return wfKor;
	}


	public void setWfKor(String wfKor) {
		this.wfKor = wfKor;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}

	
	
	
}
