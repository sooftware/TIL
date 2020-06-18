package day180719;

import java.util.*;

public class Cart {
	Scanner sc = new Scanner(System.in);
	/* 상품 추가 */
	public void add(LinkedList goods, LinkedList customer, LinkedList cart) {
		String name = null;
		String phone_number = null;
		String goods_name;
		String buffer;
		char yes_or_no;
		boolean find=false;
		boolean login = false;

		/* 고객 이름, 폰번호 이용해서 로그인 */
		System.out.print("고객님의 이름을 입력해주세요. : ");
		name = sc.next();
		for (int i = 0; i < customer.size() - 2; i += 3) {
			if (name.equals((String) customer.get(i))) {
				System.out.print("고객님의 폰 번호를 입력해주세요. :");
				phone_number = sc.next();
				if (phone_number.equals((String) customer.get(i + 1))) {
					login = true;
					if (login) {
						System.out.println("로그인에 성공하셨습니다!!");
					} else {
						System.out.println("로그인에 실패하셨습니다!!");
						return;
					}
				}
			}
		}
		/* 고객 이름, 폰번호 이용해서 로그인 */

		while (true) {

			System.out.print("원하시는 상품명을 입력해주세요 : ");
			goods_name = sc.next();

			for (int i = 1; i < goods.size() - 2; i += 4) {
				if (goods_name.equals((String) goods.get(i))) {
					find=true;
					System.out.println("## 상품명 : " + goods.get(i));
					System.out.println("## 가격 : " + goods.get(i + 1));
					System.out.println("## 상품설명 : " + goods.get(i + 2));
					System.out.println("## 상품코드 : " + goods.get(i - 1));
ㄹ
					System.out.print("\n해당 상품을 장바구니에 담으시겠습니까??? (y/n)");
					buffer = sc.next();
					yes_or_no = buffer.charAt(0);

					switch (yes_or_no) {
					case 'y':
					case 'Y':
						cart.add(name);	// 고객 이름
						cart.add(phone_number);	// 고객 폰 번호
						cart.add(goods.get(i)); // 상품명
						cart.add(goods.get(i + 1)); // 가격
						cart.add(goods.get(i - 1)); // 상품코드
						
						/* 장바구니에 담기면 상품 삭제 */
						for(int j=0;j<4;j++){
							goods.remove(i-1); // 상품명으로 찾는데 상품명이 2번째 요소이므로 i-1부터 4번 삭제
						}
						
						break;

					case 'n':
					case 'N':

						break;

					default:
						break;
					}

				}
			}
			if(!find){
				System.out.println("해당하는 상품이 없습니다 ㅜ.ㅜ");
			}
			
			System.out.print("계속 하시겠습니까?? 그만두시려면 N을 눌러주세요 : ");
			buffer = sc.next();
			yes_or_no = buffer.charAt(0);
			switch (yes_or_no) {
			case 'n':
			case 'N':
				return;
			default:
				break;
			}
		}
	}
	/* 상품 추가 */
	
	/* 고객 장바구니 조회 */
	public void search_customer_linked_cart(LinkedList cart){
		String customer_name;
		
		System.out.print("장바구니 조회하실 고객이름을 입력해주세요 : ");
		customer_name = sc.next();
		
		System.out.println("=====" + customer_name +"님의 장바구니 리스트=====");
		
		for(int i=0;i<cart.size()-4;i+=5){
			if(customer_name.equals((String)cart.get(i))){
			System.out.println("========================");
			
			System.out.println("고객 이름 : " + cart.get(i));
			System.out.println("고객 폰 번호 : " + cart.get(i+1));
			System.out.println("구입한 상품명 : " +cart.get(i+2) );
			System.out.println("구입한 상품 가격 :  " + cart.get(i+3));
			System.out.println("구입한 상품 코드 :  " + cart.get(i+4));
			
			System.out.println("========================");
			}
		}
	}
	/* 고객 장바구니 조회 */

}
