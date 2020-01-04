package customer;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/* Customer Management */
public class CustomerManagement implements PublicConstants {
	private ArrayList<Customer> customers;
	private String hashType;
	Scanner sc;

	CustomerManagement(ArrayList<Customer> customerList) {
		this.customers = customerList;
		sc = new Scanner(System.in);
		hashType = "SHA-256";
	}

	/* 0. 고객 명단 출력 */
	public void printCustomers() {
		if (customers.size() == 0)
			System.out.println(NO_EXIST_CUSTOMER_MSG);
		else {
			for (Customer customer : this.customers)
				System.out.println(customer.getCustomerNo() + "\t" + customer.getPassword() + "\t" + customer.getName()
						+ "\t" + customer.getGender() + "\t" + customer.getPhoneNum() + "\t" + customer.getPoint());
		}
	}

	public boolean cnoAlreadyExist(String customerNo) {
		for (Customer customer : this.customers)
			if (customer.getCustomerNo().equals(customerNo))
				return true;
		return false;
	}

	/* 1. 신규 고객 등록 */

	public Customer registerNewCustomer() throws NoSuchAlgorithmException {
		Customer newbie = new Customer();
		String input;
		boolean again = false;
		do {
			if (again) System.out.println(CNO_ALREADY_EXIST_MSG);
			System.out.print(CNO_INPUT_MSG);
			input = sc.next();
			again = true;
		} while (cnoAlreadyExist(input));
		newbie.setCustomerNo(input);
		again = false;
		do {
			if (again) System.out.println(PASSWD_MISMATCH_MSG);
			System.out.print(PASSWD_INPUT_MSG);
			newbie.setPassword(this._getHashing(sc.next(), this.hashType));
			System.out.print(PASSWD_CHECK_MSG);
			again = true;
		} while ( !(newbie.getPassword().equals( this._getHashing(sc.next(), this.hashType) ) ) );
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
		return newbie;
	}

	/* 2. 고객 정보 수정 */

	public void modifyCustomerInfo() throws NoSuchAlgorithmException {
		customers.set(this._searchCustomer(MODIFY_CUSTOMER_MSG), this.registerNewCustomer());
	}

	/* 3. 고객 포인트 조회 */

	public void lookupCustomerPoint() {
		Customer customer = this.customers.get(this._searchCustomer(LOOKUP_CUSTOMER_MSG));
		System.out.println(customer.getName() + "님의 현재 잔여 포인트는 " + customer.getPoint() + " 포인트 입니다.");
	}

	/* 4. 고객 삭제 */

	public void deleteCustomer() {
		this.customers.remove(this._searchCustomer(DELETE_CUSTOMER_MSG));
	}

	/* 고객 리스트에서 고객 정보를 찾는 메서드 */

	private int _searchCustomer(String message) {
		String customerNo;
		while (true) {
			System.out.print(message);
			customerNo = sc.next();
			for (Customer customer : this.customers) {
				if (customer.getCustomerNo().equals(customerNo))
					return this.customers.indexOf(customer);
			}
			System.out.println(INVALID_CUSTOMER_NO_MSG);
		}
	}

	/* 문자열을 해싱해주는 메서드 */
	private String _getHashing(String string, String hashType) throws NoSuchAlgorithmException {
		MessageDigest md;
		md = MessageDigest.getInstance(hashType);
		byte[] hashByte = md.digest(string.getBytes());
		StringBuffer buf = new StringBuffer();
		for(byte b : hashByte)
			buf.append(Integer.toString((b &0xff) +0x100,16).substring(1));
		return buf.toString();
	}
	
	/* Get & Set */

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	/* Get & Set */
}
