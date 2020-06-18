package dept1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class DatabaseEx {
	private String url;
	private String username;
	private String password;
	Connection conn = null;
	Scanner sc = new Scanner(System.in);

	/* 생성자 함수 */
	public DatabaseEx() throws ClassNotFoundException {
		url = "jdbc:oracle:thin:@localhost:1521:orcl";
		username = "scott";
		password = "tiger";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
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

	/* 삽입 */
	public void insert() {
		ArrayList Dept = new ArrayList();
		
		System.out.print("부서번호 : ");
		Dept.add( sc.next());
		System.out.print("부서위치 : ");
		Dept.add( sc.next());
		System.out.print("부서 이름 : ");
		Dept.add( sc.next());

		insert_Logic(Dept);
	}

	public void insert_Logic(ArrayList Dept) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO DeptTest VALUES('" + Dept.get(0) + "','" +  Dept.get(1) + "','" +  Dept.get(2) + "')";

			
			int result = stmt.executeUpdate(sql);

			System.out.println(result + "개의 행이 삽입되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/* 삽입 */

	/* 삭제 */
	public void delete() {
		System.out.print("삭제하실 부서번호를 입력해주세요 : ");
		String deptno = sc.next();

		delete_Logic(deptno);
	}

	public void delete_Logic(String deptno) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "DELETE DeptTest WHERE deptno=" + deptno;
			int result = stmt.executeUpdate(sql);

			System.out.println(result + "개의 부서가 삭제되었습니다."); // executeQuery :
															// DQL
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
	public void update() {
		String sql = null;
		Statement stmt = null;
		int choice = 0;
		ArrayList Dept = new ArrayList();

		System.out.print("##부서번호 : ");
		Dept.add(sc.next());

		System.out.println("## 바꿀 정보를 선택해주세요");
		System.out.println("## 1. 부서번호");
		System.out.println("## 2. 부서위치");
		System.out.println("## 3. 부서이름");
		do {
			choice = sc.nextInt();
		} while (choice < 1 || choice > 3);

		switch (choice) {
		case 1:
			System.out.print("바꿀 부서 번호 : ");
			Dept.add(sc.next();
			update_Logic_ChangeNumber(Dept,stmt,sql);
			break;
		case 2:
			System.out.print("바꿀 부서 위치 : ");
			Dept.add(sc.next();
			update_Logic_ChangeLocation(Dept,stmt,sql);
			break;
		case 3:
			System.out.print("바꿀 부서 이름 : ");
			Dept.add(sc.next();
			update_Logic_ChangeName(Dept,stmt,sql);
			break;
		default:
			break;
		}
	}

	public void update_Logic_ChangeNumber(ArrayList Dept,Statement stmt,String sql) {
		try {
			stmt = conn.createStatement();
			sql = "UPDATE DeptTest SET " + " deptno = '" +  Dept.get(0) + "' WHERE deptno = " +  Dept.get(1);
			int result = stmt.executeUpdate(sql);
			System.out.println(result + "개의 행이 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update_Logic_ChangeLocation(ArrayList Dept,Statement stmt,String sql) {
		try {
			stmt = conn.createStatement();
			sql = "UPDATE DeptTest SET " + "dept_location = '" + Dept.get(0) + "' WHERE deptno = " +Dept.get(1);
			int result = stmt.executeUpdate(sql);
			System.out.println(result + "개의 행이 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update_Logic_ChangeName(ArrayList Dept,Statement stmt,String sql) {
		try {
			stmt = conn.createStatement();
			sql = "UPDATE DeptTest SET " + "dept_name = '" +Dept.get(0) + "' WHERE deptno = " +Dept.get(0);
			int result = stmt.executeUpdate(sql);
			System.out.println(result + "개의 행이 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
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