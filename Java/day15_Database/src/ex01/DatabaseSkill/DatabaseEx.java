package ex01.DatabaseSkill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseEx {
	private String url;
	private String username;
	private String password;
	Connection conn = null;
	String dept_name;
	String dept_location;
	String dept_num;
	Scanner sc = new Scanner(System.in);

	/* 생성자 함수 */
	public DatabaseEx() {
		url = "jdbc:oracle:thin:@localhost:1521:orcl";
		username = "scott";
		password = "tiger";
		dept_name=null;
		dept_location=null;
		dept_num=null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (conn == null) {
			System.out.println("연결이 되지 않았습니다");
		} else {
			System.out.println("연결되었습니다!!");
		}
	}
	/* 생성자 함수 */

	/* 삽입 */
	public void insert() {
		System.out.print("부서번호 : ");
		this.dept_num = sc.next();
		System.out.print("부서위치 : ");
		this.dept_location = sc.next();
		System.out.print("부서 이름 : ");
		this.dept_name = sc.next();
		
		try {
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO DeptTest VALUES('" + dept_num + "','"+ dept_location + "','"  + dept_name +"')";

			int result = stmt.executeUpdate(sql);

			System.out.println(result +"개의 행이 삽입되었습니다."); 

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/* 삽입 */
	
	/* 삭제 */
	public void delete(){
		String deptno=null;
		
		System.out.print("삭제하실 부서번호를 입력해주세요 : ");
		deptno=sc.next();
		
		
		try {
			Statement stmt = conn.createStatement();
			String sql = "DELETE DeptTest WHERE deptno=" + deptno ;
			int result = stmt.executeUpdate(sql);
			
			System.out.println(result +"개의 부서가 삭제되었습니다."); // executeQuery : DQL
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/* 삭제 */
	
	/* 조회 */
	public void display(){
		String sql = "SELECT * FROM DeptTest";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString(1)+", "+rs.getString(2)+", "+ rs.getString(3) );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/* 조회 */
	
	/* 수정 */
	public void update(){
		String sql = null;
		Statement stmt;
		int choice=0;
		
		System.out.print("##부서번호 : ");
		String dept_num=sc.next();
		
		System.out.println("## 바꿀 정보를 선택해주세요");
		System.out.println("## 1. 부서번호");
		System.out.println("## 2. 부서위치");
		System.out.println("## 3. 부서이름");
		do{
			choice = sc.nextInt();
		}while(choice<1 || choice>3);
		
		switch(choice){
		case 1:
			System.out.print("바꿀 부서 번호 : ");
			String change_num=sc.next();
			try {
				stmt = conn.createStatement();
				sql = "UPDATE DeptTest SET " +" deptno = '" + change_num +"' WHERE deptno = " + dept_num;
				int result = stmt.executeUpdate(sql);
				System.out.println(result +"개의 행이 수정되었습니다."); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.print("바꿀 부서 위치 : ");
			String change_location=sc.next();
			try {
				stmt = conn.createStatement();
				sql = "UPDATE DeptTest SET " + "dept_location = '" + change_location +"' WHERE deptno = " + dept_num;
				int result = stmt.executeUpdate(sql);
				System.out.println(result +"개의 행이 수정되었습니다."); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			System.out.print("바꿀 부서 이름 : ");
			String change_name=sc.next();
			try {
				stmt = conn.createStatement();
				sql = "UPDATE DeptTest SET "+ "dept_name = '" + change_name +"' WHERE deptno = " + dept_num;
				int result = stmt.executeUpdate(sql);
				System.out.println(result +"개의 행이 수정되었습니다."); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
			default : 
			
				break;
		}
		
		
	}
	/* 수정 */
	
	/* SET & GET */

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/* SET & GET */
}