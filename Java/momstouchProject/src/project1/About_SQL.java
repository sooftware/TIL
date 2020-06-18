package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class About_SQL {
	private String url;
	private String username;
	private String password;
	Connection conn = null;
	Scanner sc = new Scanner(System.in);

	/* SQL과의 연결을 해주는 method */
	public void connect_SQL() {
		url = "jdbc:oracle:thin:@localhost:1521:xe";
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

	/* 메뉴코드에 해당하는 재료들을 SQL에서 가져오는 method */
	public void bring_SQL(int code, LinkedList component_name, LinkedList component_num, LinkedList component_min) {
		String sql = "SELECT * FROM menu_component WHERE menu_code = " + code;
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				component_name.add(rs.getString(2));
				component_num.add(rs.getDouble(3));
				component_min.add(rs.getDouble(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* 이름이 중복되는 것들은 개수를 합쳐주고 리스트에서 삭제를 해주는 method */
	public void nameOverlap(LinkedList component_name, LinkedList component_num, LinkedList component_min) {
		for (int i = 0; i < component_name.size(); i++) {
			for (int j = i + 1; j < component_name.size(); j++) {
				/* component_name의 i와j index에서 이름이 같다면 아래를 실행한다 */
				if (component_name.get(i).toString().equals(component_name.get(j).toString())) {
					String str1 = component_num.get(i)
							.toString(); /* LinkedList -> String */
					Double num1 = Double
							.parseDouble(str1); /* String -> Double */
					String str2 = component_num.get(j)
							.toString(); /* LinkedList -> String */
					Double num2 = Double
							.parseDouble(str2); /* String -> Double */

					/* i번째와 j번째가 같다면 거기에 해당하는 개수들을 더해서 i번째에 set을 해준다 */
					component_num.set(i, num1 + num2);

					component_name.remove(j); /* 1. j번째를 모두 지운다 */
					component_num.remove(j); /*
												 * 2. j번째를 지우면 j+1번째부터 뒤의 모든
												 * LinkedList들이 앞으로 당겨지므로
												 */
					component_min.remove(
							j); /* 3. j--를 해줌으로써 한칸씩 넘어가버리는 문제가 생기지 않도록 해준다 */
					j--; /* <- 요놈 지우면 문제가 생긴다 */
				}
			}
		}
	}

	public void searchCode(Vector<String> codeBuffer, Vector<Integer> codeReceive) {
		for (int i = 0; i < codeBuffer.size(); i++) {
			String sql = "SELECT menu_code FROM menu WHERE menu_name = '" + codeBuffer.get(i)+"'";
			Statement stmt;
			try {
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					codeReceive.addElement(rs.getInt(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
