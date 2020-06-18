package chatProgram;

/*
 * KwangWoon University
 * 2019년도 1학기 객체지향프로그래밍실습 
 * 개인프로젝트
 * 전자통신공학과 2014707073 김수환
 * 주제 : 멀티캐스트 다중 채팅 프로그램
 * Class : 오라클 DB와 연결하는 클래스
 */

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDBConnector implements ChatInterface{
	private String url;
	private String username;
	private String password;
	private Connection con = null;
	
	/* Oracle Database와 연결하는 생성자 */
	OracleDBConnector() {
		url=null;
		username=null;
		password=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			/* 현재 내 컴퓨터 IP와 SID를 집어넣음 */
			url = "jdbc:oracle:thin:@" + DATABASE_IP +":1521:"+DATABASE_SID;	
			username = "scott";	/* DB Test ID */
			password = "tiger";	/* DB Test Password */
			con = DriverManager.getConnection(url, username, password); /* 연결 */
			System.out.println(InetAddress.getLocalHost()); /* IP를 확인하기 위한 print */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Get Method */
	public Connection getCon() {
		return con;
	}
}