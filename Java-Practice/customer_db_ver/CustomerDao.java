package customer2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

/* Data Access Object */
public class CustomerDao implements PublicConstants {
	private String url;
	private String username;
	private String password;
	private String hashType;
	private String query;
	private Statement stmt;
	private Connection conn;
	Scanner sc;

	/* Init */

	CustomerDao() {
		this.sc = new Scanner(System.in);
		this.url = "jdbc:oracle:thin:@localhost:1521:orcl";
		this.username = null;
		this.password = null;
		this.conn = null;
		this.hashType = "SHA-256";
		this.query = null;
		this.stmt = null;
	}

	/* Connect */

	public boolean connect() {
		System.out.print(DB_LOGIN_ID_MSG);
		this.username = sc.next();
		System.out.print(DB_LOGIN_PASSWD_MSG);
		this.password = sc.next();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(this.url, this.username, this.password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (conn == null) {
			System.out.println(DB_NOT_CONN_MSG);
			return false;
		} else {
			System.out.println(DB_CONN_MSG);
			return true;
		}
	}

	/* 0. Database에서 읽은 Customer 리스트를 출력하는 메서드 */

	public void printCustomers() {
		this.query = "SELECT * FROM " + CUSTOMER_TABLE_NAME;
		try {
			this.stmt = this.conn.createStatement();
			ResultSet rs = this.stmt.executeQuery(this.query);
			while (rs.next()) {
				System.out.println(rs.getString(CUSTOMER_TABLE_ATTRS[0]) + TAP + rs.getString(CUSTOMER_TABLE_ATTRS[1])
						+ TAP + rs.getString(CUSTOMER_TABLE_ATTRS[2]) + TAP + rs.getString(CUSTOMER_TABLE_ATTRS[3])
						+ TAP + rs.getInt(CUSTOMER_TABLE_ATTRS[4]));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* 1. 새로운 고객을 추가하는 메서드 */

	public void insertNewbie() throws NoSuchAlgorithmException {
		Customer newbie = new Customer();
		boolean again = false;
		newbie.setCustomerNo(this.inputCno(false));
		do {
			if (again)
				System.out.println(PASSWD_MISMATCH_MSG);
			System.out.print(PASSWD_INPUT_MSG);
			newbie.setPassword(this.getHashValue(sc.next(), this.hashType));
			System.out.print(PASSWD_CHECK_MSG);
			again = true;
		} while (!(newbie.getPassword().equals(this.getHashValue(sc.next(), this.hashType))));
		System.out.print(PNUM_INPUT_MSG);
		newbie.setPhoneNum(sc.next());
		System.out.print(CNAME_INPUT_MSG);
		newbie.setName(sc.next());
		System.out.print(GENDER_INPUT_MSG);
		newbie.setGender(sc.next());
		System.out.print(POINT_INPUT_MSG);
		try {
			newbie.setPoint(sc.nextInt());
		} catch (InputMismatchException e) {
			System.out.println(INT_MISMATCH_EXCEPT_MSG);
			newbie.setPoint(sc.nextInt());
		}
		System.out.println(this.insertIntoDB(newbie) + "개의 행이 업데이트 되었습니다.");
	}

	/* 입력받은 내용을 기반으로 Database에 고객을 추가하는 메서드 */

	private int insertIntoDB(Customer newbie) {
		int updateNum = 0;
		this.query = "INSERT INTO " + CUSTOMER_TABLE_NAME + " VALUES";
		try {
			this.stmt = this.conn.createStatement();
			this.query += SQL_OPEN + newbie.getCustomerNo() + SQL_COMMA + newbie.getName() + SQL_COMMA
					+ newbie.getPassword() + SQL_COMMA + newbie.getPhoneNum() + SQL_COMMA + newbie.getGender() + "',"
					+ newbie.getPoint() + SQL_INT_CLOSE;
			updateNum = this.stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateNum;
	}

	/* 2. 고객 정보를 수정하는 메서드 */

	public void updateInfo() throws NoSuchAlgorithmException {
		boolean loginSuccess = this.adminLogin();
		if (!loginSuccess)
			return;
		this.printCustomers();
		String customerNo = this.inputCno(true);
		for (String attr : CUSTOMER_TABLE_ATTRS)
			System.out.println(attr);
		System.out.print(UPDATE_ATTR_MSG);
		String updateAttr = sc.next();
		System.out.print(UPDATE_VALUE_MSG);
		String updateValue = sc.next();
		System.out.println(this.updateIntoDB(CUSTOMER_TABLE_NAME, customerNo, updateAttr, updateValue) + "개의 행이 업데이트 되었습니다.");
	}

	/* 입력받은 내용을 기반으로 Database에서 고객 정보를 수정하는 메서드 */

	private int updateIntoDB(String table, String customerNo, String updateAttr, String updateValue) {
		int updateNum = 0;
		try {
			this.stmt = this.conn.createStatement();
			if (updateAttr.equalsIgnoreCase("POINT_"))
				this.query = "UPDATE " + table + " SET " + updateAttr + " = " + updateValue + " WHERE CUSTOMER_NO = '"
						+ customerNo + "'";
			else
				this.query = "UPDATE " + table + " SET " + updateAttr + " = '" + updateValue + "' WHERE CUSTOMER_NO = '"
						+ customerNo + "'";
			updateNum = this.stmt.executeUpdate(this.query);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return updateNum;
	}

	/* 3. 고객의 포인트를 조회하는 메서드 */

	public void lookupPoint() {
		String customerNo = this.inputCno(true);
		this.query = "SELECT CUSTOMER_NO, POINT_, CUSTOMER_NAME FROM " + CUSTOMER_TABLE_NAME;
		try {
			this.stmt = this.conn.createStatement();
			ResultSet rs = this.stmt.executeQuery(this.query);
			while (rs.next()) {
				if (rs.getString("CUSTOMER_NO").equals(customerNo))
					System.out.println(rs.getString("CUSTOMER_NAME") + "님의 잔여 포인트는 " + rs.getString("POINT_") + "입니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* 4. 고객 정보를 삭제하는 메서드 */
	public void deleteInfo() {
		String customerNo = this.inputCno(true);
		int updateNum = 0;
		this.query = "DELETE "+CUSTOMER_TABLE_NAME+" WHERE CUSTOMER_NO = '" + customerNo + "'";
		try {
			this.stmt = this.conn.createStatement();
			updateNum = this.stmt.executeUpdate(this.query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(updateNum + "개의 행이 업데이트 되었습니다.");
	}
	
	/* 관리자 권한으로 로그인하는 메서드 */

	private boolean adminLogin() throws NoSuchAlgorithmException {
		System.out.print(ADMIN_LOGIN_ID_MSG);
		String adminId = sc.next();
		System.out.print(ADMIN_LOGIN_PASSWD_MSG);
		String passwd = sc.next();

		this.query = "SELECT * FROM " + ADMIN_TABLE_NAME;
		try {
			this.stmt = this.conn.createStatement();
			ResultSet rs = this.stmt.executeQuery(this.query);
			while (rs.next()) {
				if (rs.getString("ADMIN_ID").equals(adminId) && rs.getString("PASSWD").equals(passwd))
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(ADMIN_LOGIN_FAIL_MSG);
		return false;
	}

	/* customerNo를 입력받는 메서드 */

	private String inputCno(boolean existWant) {
		String customerNo = null;
		boolean again = false;
		if (existWant) {
			do {
				if (again)
					System.out.println(CNO_ALREADY_EXIST_MSG);
				System.out.print(CNO_INPUT_MSG);
				customerNo = sc.next();
				again = true;
			} while (!this.isCnoExist(customerNo));
		}else {
			do {
				if (again)
					System.out.println(CNO_ALREADY_EXIST_MSG);
				System.out.print(CNO_INPUT_MSG);
				customerNo = sc.next();
				again = true;
			} while (this.isCnoExist(customerNo));
		}
		return customerNo;
	}

	/* customerNo가 이미 있는 번호인지를 체크하는 메서드 */

	private boolean isCnoExist(String customerNo) {
		String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME;
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString("CUSTOMER_NO").equals(customerNo))
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/* 문자열을 해싱해주는 메서드 */

	private String getHashValue(String string, String hashType) throws NoSuchAlgorithmException {
		MessageDigest md;
		md = MessageDigest.getInstance(hashType);
		byte[] hashByte = md.digest(string.getBytes());
		StringBuffer buf = new StringBuffer();
		for (byte b : hashByte)
			buf.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		return buf.toString();
	}
}
