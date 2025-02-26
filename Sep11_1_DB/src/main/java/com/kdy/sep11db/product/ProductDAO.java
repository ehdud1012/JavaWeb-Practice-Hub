package com.kdy.sep11db.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.Name;
import javax.naming.NameClassPair;
import javax.naming.NameParser;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.sql.DataSource;

// 원격지에 OracleDB서버가 있는데 원격제어 필요
// 그 프로그앰이 sqlPlus인데 불편 -> EclipesIDE로 하자

// .sql 파일을 만들어야겠는데 프로젝트 없이는 파일 못만듬
// 그냥 지금 프로젝트에 대충 만들어 쓰다 버리자 

// 개발중인 프로젝트랑 상관없음
// 		Java + OracleDB에 필요한 Driver가 없음
//		Oracle에서 만들어준 Driver ojdbc8.jar

public class ProductDAO {
	// ConnectionPool 방식
	//		미리 만들어놓은 Connection 을 빠르게 주는 방식
	//		톰캣이 필요했기에 전에는 사용못한 것
	//		톰캣에 설정파일을 만들어놔야 함
	
	// 웹 개발자는 여러 프로젝트를 진행하는데
	//		-> DB서버가 다 같은가? XX
	//		=> 프로젝트 별로 톰캣 설정파일을 다 따로 쓰는게 맞다
	//			- 프로젝트에 있는 META-INF폴더에 톰캣 설정 파일을 넣자
	
	// context.xml
	//		객체를 등록해놓고 .java에서 불러다 쓸 수 있음
	//		- name : .java에서 부를때 쓸 이름
	//		- username : id
	//		- password : pw
	//		- url : 서버주소
	//		- maxTotal : 최대동시접속자 수
	//		- maxIdle : 미리 만들어놓을 Connection 수
	
	public static void connectTest() {
		Connection con = null;
		try {
			// context.xml 
			Context ctx = new InitialContext();
			// 에 써놓은 정보 불러와서 Data Source 만들고 - 형변환 필요
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/kdyPool");
			// Connection
			con = ds.getConnection();
			System.out.println("연결성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {con.close();} catch (SQLException e) {}
	}
	
//	// JDBC 방식
//	//		필요할 때마다 Connection 을 만들어 사용 = 느려짐
//	public static void connectTestOld() {
//		Connection con = null;
//		try {
//			// 서버 주소 (DB메이커 별로 다 다름)
//			//  -> 주소 생김새로 Driver 알아서 찾아서 씀 = Java때 얘기
//			//	=> JSP에서는 자동으로 못찾아 ▽ 작성 필요
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			String url = "jdbc:oracle:thin:@192.168.0.55:1521:xe";
//			con =  DriverManager.getConnection(url, "ehdud1012", "1012");
//			System.out.println("연결성공");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		try {con.close();} catch (SQLException e) {}
//	}
}
