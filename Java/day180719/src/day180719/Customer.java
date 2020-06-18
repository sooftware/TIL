package day180719;

import java.util.*;

public class Customer {
	Scanner sc = new Scanner(System.in);
	String name;
	String phone_number;
	int age;

	/* 고객추가 */
	public void add(LinkedList customer) {
		System.out.print("고객님 이름을 입력해주세요 : ");
		name = sc.next();
		System.out.print("고객님 핸드폰 번호를 입력해주세요 : ");
		phone_number = sc.next();
		System.out.print("고객님 나이를 입력해주세요 : ");
		age = sc.nextInt();

		customer.add(name);
		customer.add(phone_number);
		customer.add(age);
	}
	/* 고객추가 */
	
	/* 고객 삭제 */
	public void remove_customer(LinkedList customer) {
		String customer_name;

		System.out.println("삭제하실 고객님 이름을 입력해주세요 : ");
		customer_name = sc.next();

		for (int i = 0; i < customer.size() - 2; i += 3) {
			if (customer_name.equals((String) customer.get(i))) {
				for(int j=0;j<3;j++){
					customer.remove(i);
				}
			}
		}
	}
	/* 고객 삭제 */
	
	/* 고객 조회 */
	public void search_customer(LinkedList customer){
		String customer_name;
		
		System.out.println("조회하실 고객님 이름을 입력해주세요 : ");
		customer_name = sc.next();

		for (int i = 0; i < customer.size() - 2; i += 3) {
			if (customer_name.equals((String) customer.get(i))) {
				System.out.println("NAME : " + customer.get(i));
				System.out.println("PHONE NUMBER : " + customer.get(i+1));
				System.out.println("AGE : " + customer.get(i+2));
			}
		}
	}
	/* 고객 조회 */
	
	/* 모든 고객 출력 */
	public void display(LinkedList customer){
		for(int i=0;i<customer.size()-2;i+=3){
			System.out.println("==============");
			
			System.out.println("NAME : " + customer.get(i));
			System.out.println("PHONE NUMBER : " + customer.get(i+1));
			System.out.println("AGE : " + customer.get(i+2));
			
			System.out.println("==============");
		}
	}
	/* 모든 고객 출력 */
	
	/* SET GET */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/* SET GET */
}
