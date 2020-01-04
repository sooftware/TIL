package customer2;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/* Customer Management */
public class CustomerManagement implements PublicConstants {
	private HashMap<String, PersonalInfo> customers;
	Scanner sc;

	CustomerManagement(HashMap<String, PersonalInfo> customers) {
		this.customers = customers;
		sc = new Scanner(System.in);
	}

	/* 0. 고객 명단 출력 */
	public void printCustomers() {
		if (this.customers.size() == 0)
			System.out.println(NO_EXIST_CUSTOMER_MSG);
		else {
			Iterator it = this.customers.keySet().iterator();
			while (it.hasNext()) {
				PersonalInfo customerInfo = customers.get(it.next());
				System.out.println(customerInfo.getName() + "\t" + customerInfo.getGender() + "\t"
						+ customerInfo.getPhoneNum() + "\t" + customerInfo.getPoint());
			}
		}
	}

	/* 해당 키가 이미 있는지 확인하는 메서드 */
	public boolean keyAlreadyExist(String key) {
		for(String cno: this.customers.keySet()) {
			if(cno.equalsIgnoreCase(key)) return true;
		}
		return false;
	}

	public void registerNewCustomer() {
		PersonalInfo newbieInfo = new PersonalInfo();
		String customerNo;
		boolean again = false;
		do {
			if(again) System.out.println(ALREADY_EXIST_PASSWD_MSG);
			System.out.print(">> 고객 번호 : ");
			customerNo = sc.next();
			again=true;
		}while(keyAlreadyExist(customerNo));
		again=false;
		
		do {
			if(again) System.out.println(">> 비밀번호가 서로 다릅니다. 다시 입력해주세요.");
			System.out.print(">> 비밀번호 : ");
			newbieInfo.setPassword(sc.next());
			System.out.print(">> 비밀번호 재확인 : ");
			again=true;
		}while(!newbieInfo.getPassword().equals(sc.next()));
		
		System.out.print(">> 핸드폰 번호 : ");
		newbieInfo.setPhoneNum(sc.next());
		System.out.print(">> 고객 이름 : ");
		newbieInfo.setName(sc.next());
		System.out.print(">> 고객 성별 : ");
		newbieInfo.setGender(sc.next());
		System.out.print(">> 고객 포인트 : ");
		try {
			newbieInfo.setPoint(sc.nextInt());
		} catch (InputMismatchException e) {
			System.out.println(INT_MISMATCH_EXCEPT_MSG);
			newbieInfo.setPoint(sc.nextInt());
		}
		customers.put(customerNo, newbieInfo);
	}
	
	/* 2. 고객 정보 수정 */

	public void modifyCustomerInfo() {
		Iterator it = customers.keySet().iterator();
		
	}

	/* 3. 고객 포인트 조회 */

	public void lookupCustomerPoint() {

	}

	/* 4. 고객 삭제 */

	public void deleteCustomer() {

	}

}
