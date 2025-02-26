package com.kdy.sep051jm.main;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

// M : Back-end 개발자
//		계산을 담당하는 M이 여러개 있을 필요는 없음
//		여러 개 만들면 RAM이 힘드렁
//		계산을 담당하는 M은 하나만 있으면 되니까
//		-> singleton
public class UnitConverter {
	private HashMap<String, String[]> units;
	private static final UnitConverter UC = new UnitConverter();
	
	private UnitConverter() {
		units = new HashMap<String, String[]>();
		units.put("len", new String[]{"cm", "inch"});
		units.put("size", new String[]{"㎡", "평"});
		units.put("temp", new String[]{"℃", "℉"});
		units.put("spd", new String[]{"km/h", "mi/h"});
	}
	
	public static UnitConverter getUc() {
		return UC;
	}

	public String cut(double d){
		return String.format("%.1f", d);
	}
	
	public void convert(HttpServletRequest request) {
		double num = Double.parseDouble(request.getParameter("input"));
		String unit = request.getParameter("unit");
		
		double result = (double)num * 0.621371;
		if (unit.equals("len")){
			result = (double)num * 0.393701;
		} else if (unit.equals("size")){
			result = (double)num * 0.3025;
		} else if (unit.equals("temp")){
			result = (double)num * 1.8 + 32;
		}
		UCResult ucr = new UCResult(num, units.get(unit)[0], result, units.get(unit)[1], unit);
		request.setAttribute("result", ucr);
	}
}
