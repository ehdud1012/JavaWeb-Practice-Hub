package com.kdy.sep052el.main;

public class BMIresult {
	private String name;
	private String path;
	private double h;
	private double w;
	private double bmi;
	private String result;
	
	public BMIresult() {
		// TODO Auto-generated constructor stub
	}

	public BMIresult(String name, String path, double h, double w, double bmi, String result) {
		super();
		this.name = name;
		this.path = path;
		this.h = h;
		this.w = w;
		this.bmi = bmi;
		this.result = result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
