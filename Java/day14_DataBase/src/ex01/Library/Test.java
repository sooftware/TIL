package ex01.Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// DBMS에 접속하기 위해서는 어떤 정보가 필요합니까????
// DBMS의 IP주소와 포트
// 창고관리인에게 접속하기 위한 아이디 비번 scott / tifer

public class Test {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "scott";
		String password = "tifer";
		Connection conn = null; 
		Scanner sc = new Scanner(System.in);
		
		System.out.print("INPUT NUMBER : ");
		int num=sc.nextInt();
		System.out.print("INPUT "	+ "NAME : ");
		String name =sc.next();
		System.out.print("INPUT PRICE : ");
		int price=sc.nextInt();
		System.out.print("INPUT DESCRIPTION : ");
		String des=sc.next();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,username,password);
			String sql = "INSERT INTO test VALUES("+num+",'"+name+"',"+price+",'"+des+"')";	// 너무 더러워서 다른 방법이 생김
		//	String sql = "INSERT INTO test VALUES(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);		// ?로 매꿔둔 곳을 preparedstatement에 일단 받아두고,
/*			pstmt.setInt(1, num);
			pstmt.setString(2, name);
			pstmt.setInt(3, price);
			pstmt.setString(4, des);  // 요런 방법이 있다는 것도 참고!! 
*/			
			
			Statement stmt = conn.createStatement();		// stmt를 날리는 종류 executeUpdate : DML -> 결과가 영향을 받은 레코드의 갯수
			stmt.executeQuery(sql);
			//int result = pstmt.executeUpdate(sql);
			//System.out.println(result + "개의 행이 영향받았습니다.");	// 									  executeQuery : DQL -> 
																															//   									  execute : DDL
		}catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}

/*
 자바 클래스들을 모아서 묶어놓은 파일이 jar
 
프로젝트에서 ~~.jar파일을 가져오는 방법

제일 추천드리는 방법
-> 프로젝트 내부에 파일을 넣어두고 내부참조 할 것
 
 
 
 ====================

 1. Connection 객체 획득
 2. 날릴 SQL구문을 Statement객체로 준비
 3. 투척
 
 */



























