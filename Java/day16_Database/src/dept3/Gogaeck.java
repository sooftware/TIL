package dept3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/* 생성자 함수 */
public class Gogaeck {
	private String url;
	private String username;
	private String password;
	Connection conn = null;
	Scanner sc = new Scanner(System.in);

	/* 생성자 함수 데이터베이스와 연결 담당 */
	public Gogaeck() {
		url = "jdbc:oracle:thin:@localhost:1521:orcl";
		username = "scott";
		password = "tiger";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (conn == null) {
			System.out.println("데이터베이스와 연결이 되지 않았습니다");
		} else {
			System.out.println("데이터베이스와 연결되었습니다!!");
		}
	}
	/* 생성자 함수 */

	/* 삽입 UI */
	public void insert() {
		String sql = "SELECT * FROM gogaeck";
		
		System.out.print("고객번호 : ");
		int gno=sc.nextInt();
		System.out.print("고객이름 : ");
		String gname=sc.next();
		System.out.print("주민번호 : ");
		String jumin=sc.next();
		System.out.print("마일리지 : ");
		int mileage=sc.nextInt();
		
		System.out.println(insert_Logic(gno,gname,jumin,mileage,sql) + "개의 행이 삽입되었습니다.");
	}
	/* 삽입 UI */

	/* 삽입 LOGIC */
	public int insert_Logic(int gno,String gname,String jumin,int mileage,String sql) {
		boolean gno_Exist=false;
		boolean isNot13=false;
		Statement stmt = null;
		/*  gno 중복체크 */
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				if(gno==rs.getInt(1)){
					gno_Exist=true;
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*  gno 중복체크 */
		
		if(gno_Exist){
			throw new GnoAlreadyExistException();
		}
		
		
		if(jumin.length() != 13){
			isNot13=true;
		}
		if(isNot13){
			throw new isNotJuminException();
		}

		try {
			sql = "INSERT INTO gogaeck VALUES('" + gno + "','" + gname + "','" + jumin + "','"+ mileage + "')";

			int result = stmt.executeUpdate(sql);

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	/* 삽입 LOGIC */

	/* 삭제 UI */
	public void delete() {
		System.out.print("삭제하실 고객번호를 입력해주세요 : ");
		int gno = sc.nextInt();

		System.out.println(delete_Logic(gno) + "개의 부서가 삭제되었습니다.");
	}
	/* 삭제 UI */

	/* 삭제 LOGIC */
	public int delete_Logic(int gno) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "DELETE gogaeck WHERE GNO=" + gno;
			int result = stmt.executeUpdate(sql);

			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	/* 삭제 LOGIC */

	/* 조회 */

	public void display() {
		String sql = "SELECT * FROM gogaeck";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(
						rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/* 조회 */

	/* 수정 UI */
	public void update() {
		String sql = null;
		Statement stmt = null;
		int choice = 0;
		int gno=0,change_gno=0,change_mileage=0;
		String change_gname=null,change_jumin=null;
		

		System.out.print("##고객번호 : ");
		gno=sc.nextInt();

		System.out.println("## 바꿀 정보를 선택해주세요");
		System.out.println("## 1. 고객번호");
		System.out.println("## 2. 고객이름");
		System.out.println("## 3. 주민번호");
		System.out.println("## 4. 마일리지");
		do {
			choice = sc.nextInt();
		} while (choice < 1 || choice > 4);

		switch (choice) {
		case 1:
			System.out.print("바꿀 고객 번호 : ");
			change_gno=sc.nextInt();
			System.out.println(update_Logic_ChangeGno(stmt, sql,gno,change_gno) + "개의 행이 수정되었습니다.");
			break;
		case 2:
			System.out.print("바꿀 고객 이름 : ");
			change_gname=sc.next();
			System.out.println(update_Logic_ChangeGname(stmt, sql,gno,change_gname) + "개의 행이 수정되었습니다.");
			break;
		case 3:
			System.out.print("바꿀 주민 번호 : ");
			change_jumin=sc.next();
			System.out.println(update_Logic_ChangeJumin(stmt, sql,gno,change_jumin) + "개의 행이 수정되었습니다.");
			break;
		case 4:
			System.out.print("바꿀 마일리지 : ");
			change_mileage=sc.nextInt();
			System.out.println(	update_Logic_ChangeMileage(stmt, sql,gno,change_mileage) + "개의 행이 수정되었습니다.");
			break;
		default:
			break;
		}
	}
	/* 수정 UI */

	/* 수정 LOGIC */
	
	/* 고객번호변경 */
	public int update_Logic_ChangeGno(Statement stmt, String sql,int gno,int change_gno) {
		boolean gno_Exist=false;
		/*  gno 중복체크 */
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				if(gno==rs.getInt(1)){
					gno_Exist=true;
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*  gno 중복체크 */
		
		/* gno 중복 발생시 GnoAlreadyExistException 발생 */
		if(gno_Exist){
			throw new GnoAlreadyExistException();
		}
		
		
		try {
			stmt = conn.createStatement();
			sql = "UPDATE gogaeck SET " + " gno = '" + change_gno + "' WHERE gno = " + gno;
			int result = stmt.executeUpdate(sql);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/* 이름변경 */
	public int update_Logic_ChangeGname(Statement stmt, String sql,int gno,String change_gname) {
		try {
			stmt = conn.createStatement();
			sql = "UPDATE gogaeck SET " + "gname = '" + change_gname + "' WHERE gno = " + gno;
			int result = stmt.executeUpdate(sql);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/* 주민변경 */
	public int update_Logic_ChangeJumin( Statement stmt, String sql,int gno,String change_jumin) {
		boolean isNot13=false;
		
		if(change_jumin.length() != 13){
			isNot13=true;
		}
		if(isNot13){
			throw new isNotJuminException();
		}

		try {
			stmt = conn.createStatement();
			sql = "UPDATE gogaeck SET " + "jumin = '" + change_jumin + "' WHERE gno = " +gno;
			int result = stmt.executeUpdate(sql);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/* 마일리지 변경 */
	public int update_Logic_ChangeMileage(Statement stmt, String sql,int gno,int change_mileage) {
		try {
			stmt = conn.createStatement();
			sql = "UPDATE gogaeck SET " + "MILEAGE = '" + change_mileage + "' WHERE gno = " + gno;
			int result = stmt.executeUpdate(sql);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	/* 수정 LOGIC */

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

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	/* SET & GET */
}