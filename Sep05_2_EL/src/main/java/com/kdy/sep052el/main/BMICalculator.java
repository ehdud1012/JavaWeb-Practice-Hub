package com.kdy.sep052el.main;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BMICalculator {
	
	public String cut(double d){
		return String.format("%.1f", d);
	}
	
	public static void calculator(HttpServletRequest request) {
		
		try {
			MultipartRequest mr = new MultipartRequest
					(request, request.getSession().getServletContext().getRealPath("Sep05_2_photo"), 
							10485760, "euc-kr", new DefaultFileRenamePolicy());	
			String p = mr.getFilesystemName("photo");
			p = URLEncoder.encode(p, "euc-kr");
			p = p.replace("+", " ");
			
			String name = mr.getParameter("name");
			Double h = Double.parseDouble(mr.getParameter("height"));
			h = h / 100;
			Double w = Double.parseDouble(mr.getParameter("weight"));
			Double bmi = w / (h * h);
			String result = "저체중";
			if(bmi >= 39) { result = "고도비만"; }
			else if(bmi >= 32) { result = "중도비만"; }
			else if(bmi >= 30) { result = "경도비만"; }
			else if(bmi >= 24) { result = "과체중"; }
			else if(bmi >= 10) { result = "정상"; }
			
			BMIresult bu = new BMIresult(name, p, h, w, bmi, result);
			request.setAttribute("result", bu);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
