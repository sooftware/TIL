package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/* 생성자 함수 */
public class DeptInsert {
	private String url;
	private String username;
	private String password;
	Connection conn = null;
	Scanner sc = new Scanner(System.in);

	public DeptInsert() {
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		username = "scott";
		password = "tifer";

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

	/* 삽입 LOGIC */
	public int insert_Logic(String gno,String gname,String jumin,String mileage) {
		String sql = "SELECT * FROM gogaeck";
		boolean gno_Exist=false;
		boolean isNot13=false;
		Statement stmt = null;
		/*  gno 중복체크 */
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				if(gno==rs.getString(1)){
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
}