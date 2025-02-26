package com.kdy.sep10ct.wc;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
public class weather {
	
	public static void weathersss(HttpServletRequest req) {
		HttpsURLConnection huc = null;
	
		try {
			URL u = URI.create("https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4159061000").toURL();
			huc = (HttpsURLConnection) u.openConnection(); // 형변환해서 사용 : 서버 연결

			InputStream is = huc.getInputStream();

			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");

			int what = xpp.getEventType();
			String tagName = null;
			
			ArrayList<WeatherInfo> weathers = new ArrayList<WeatherInfo>();
			WeatherInfo w = null;
			while (what != XmlPullParser.END_DOCUMENT) {
				if (what == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
					if (tagName.equals("data")) {
						w = new WeatherInfo();
					}
				} else if (what == XmlPullParser.TEXT){
						if (tagName.equals("hour")) {
							w.setHour(xpp.getText());
						} else if (tagName.equals("temp")){
							w.setTemp(xpp.getText());
						} else if (tagName.equals("wfKor")){
							w.setWfKor(xpp.getText());
							if (w.getWfKor().equals("맑음")) {
								w.setImg("img/w/sun.png");
							} else if (w.getWfKor().contains("구름")) {
								w.setImg("img/w/somecloud.gif");
							} else if (w.getWfKor().contains("흐림")) {
								w.setImg("img/w/cloud.png");
							} else {
								w.setImg("img/w/rain.png");
							}
						}
				} else if (what == XmlPullParser.END_TAG) {
					tagName = "";
					if (xpp.getName().equals("data")) {
						weathers.add(w);
					}
				}
				xpp.next();
				what = xpp.getEventType();
			}
			req.setAttribute("weathers", weathers);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
