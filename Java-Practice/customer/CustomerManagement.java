package customer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/* Customer Management */
public class CustomerManagement implements PublicConstants {
	private ArrayList<Customer> customerList;
	Scanner sc;

	CustomerManagement(ArrayList<Customer> customerList) {
		this.customerList = customerList;
		sc = new Scanner(System.in);
	}

	/* ## 0. 고객 명단 출력 */
	public void printCustomerList() {
		if (customerList.size() == 0) System.out.println(NO_EXIST_CUSTOMER_MSG);
		else {
			for (Customer customer : this.customerList)
				System.out.println(customer.getCustomerNo() + "\t" + customer.getName() + "\t" + customer.getGender()
						+ "\t" + customer.getPhoneNum() + "\t" + customer.getPoint());
		}
	}

	/* 1. 신규 고객 등록 */
	
	public Customer registerNewCustomer() {
		Customer newbie = new Customer();
		System.out.print(">> 고객 번호 : ");
		newbie.setCustomerNo(sc.next());
		System.out.print(">> 핸드폰 번호 : ");
		newbie.setPhoneNum(sc.next());
		System.out.print(">> 고객 이름 : ");
		newbie.setName(sc.next());
		System.out.print(">> 고객 성별 : ");
		newbie.setGender(sc.next());
		System.out.print(">> 고객 포인트 : ");
		try {
			newbie.setPoint(sc.nextInt());
		} catch (InputMismatchException e) {
			System.out.println(INT_MISMATCH_EXCEPT_MSG);
			newbie.setPoint(sc.nextInt());
		}
		return newbie;
	}

	/* 2. 고객 정보 수정 */
	
	public void modifyCustomerInfo() {
		customerList.set(this.searchCustomerList(MODIFY_CUSTOMER_MSG), this.registerNewCustomer());
	}

	/* 3. 고객 포인트 조회 */
	
	public void lookupCustomerPoint() {
		Customer customer = this.customerList.get(this.searchCustomerList(LOOKUP_CUSTOMER_MSG));
		System.out.println(customer.getName() + "님의 현재 잔여 포인트는 " + customer.getPoint() + " 포인트 입니다.");
	}

	/* 4. 고객 삭제 */
	
	public void deleteCustomer() {
		this.customerList.remove(this.searchCustomerList(DELETE_CUSTOMER_MSG));
	}
	
	/* 고객 리스트에서 고객 정보를 찾는 메서드 */
	
	public int searchCustomerList(String message) {
		String customerNo;
		while (true) {
			System.out.print(message);
			customerNo = sc.next();
			for (Customer customer : this.customerList) {
				if (customer.getCustomerNo().equals(customerNo))
					return this.customerList.indexOf(customer);
			}
			System.out.println(INVALID_CUSTOMER_NO_MSG);
		}
	}

	/* Get & Set */

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}
	/* Get & Set */
}
