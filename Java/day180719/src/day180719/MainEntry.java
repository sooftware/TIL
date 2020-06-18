package day180719;

import java.util.LinkedList;
import java.util.Scanner;

/*
 상품관리
 상품 - 상품코드 상품명 가격 상품설명
 
 고객 - 이름 전화번호 장바구니
 
 장바구니 상품 & 고객 연동
 
  사용자UI - 1 상품추가 2 상품삭제 3 상품조회 4 모든 상품 출력
  
  
  장바구니 - 고객과 상품 연동
  					- 바구니번호 상품명 가격 상품설명 수량 배송지
 */

public class MainEntry {
	public static void main(String[] args) {
		LinkedList goods = new LinkedList();
		LinkedList customer = new LinkedList();
		LinkedList cart = new LinkedList();
		Scanner sc = new Scanner(System.in);
		int goods_select = 0;
		int select = 0;
		Goods gs = new Goods();
		Customer cs = new Customer();
		Cart ct = new Cart();

		while (true) {
			System.out.println("==============");
			System.out.println("## 1. 상품 관리");
			System.out.println("## 2. 고객 관리");
			System.out.println("## 3. 장바구니 관리 ");
			System.out.println("## 4. 프로그램 종료");
			System.out.println("==============");
			do {
				System.out.print("INPUT : ");
				select = sc.nextInt();
			} while (select < 1 || select > 4);

			switch (select) {
			case 1:
				sangpum(goods, gs);
				break;
			case 2:
				gogaeck(customer, cs);
				break;
			case 3:
				jangbaguni(goods, customer, cart, ct);
				break;
			case 4:
				return;
			default:
				break;
			}
		}

	}

	public static void jangbaguni(LinkedList goods, LinkedList customer, LinkedList cart, Cart ct) {
		Scanner sc = new Scanner(System.in);
		int jang_select = 0;

		while (true) {
			System.out.println("============");
			System.out.println("## 1. 장바구니에 담기");
			System.out.println("## 2. 장바구니 조회");
			System.out.println("## 3. 뒤로가기");
			System.out.println("============");
			do {
				System.out.print("INPUT : ");
				jang_select = sc.nextInt();
			} while (jang_select < 1 || jang_select > 3);

			switch (jang_select) {
			case 1:
				ct.add(goods, customer, cart);
				break;
			case 2:
				ct.search_customer_linked_cart(cart);
				break;
			case 3:
				return;
			default:
				break;
			}
		}
	}

	public static void gogaeck(LinkedList customer, Customer cs) {
		Scanner sc = new Scanner(System.in);
		int gogaeck_select = 0;

		while (true) {
			System.out.println("============");
			System.out.println("## 1. 고객추가");
			System.out.println("## 2. 고객삭제");
			System.out.println("## 3. 고객조회");
			System.out.println("## 4. 모든 고객 출력");
			System.out.println("## 5. 뒤로가기");
			System.out.println("============");
			do {
				System.out.print("INPUT : ");
				gogaeck_select = sc.nextInt();
			} while (gogaeck_select < 1 || gogaeck_select > 5);

			switch (gogaeck_select) {
			case 1:
				cs.add(customer);
				break;
			case 2:
				cs.remove_customer(customer);
				break;
			case 3:
				cs.search_customer(customer);
				break;
			case 4:
				cs.display(customer);
				break;
			case 5:
				return;
			default:
				break;
			}
		}
	}

	public static void sangpum(LinkedList goods, Goods gs) {
		Scanner sc = new Scanner(System.in);
		int goods_select = 0;

		while (true) {
			System.out.println("============");
			System.out.println("## 1. 상품추가");
			System.out.println("## 2. 상품삭제");
			System.out.println("## 3. 상품조회");
			System.out.println("## 4. 모든 상품 출력");
			System.out.println("## 5. 뒤로가기");
			System.out.println("============");
			do {
				System.out.print("INPUT : ");
				goods_select = sc.nextInt();
			} while (goods_select < 1 || goods_select > 5);

			switch (goods_select) {
			case 1:
				gs.add(goods);
				break;
			case 2:
				gs.remove_goods(goods);
				break;
			case 3:
				gs.search_goods(goods);
				break;
			case 4:
				gs.display(goods);
				break;
			case 5:
				return;
			default:
				break;
			}
		}
	}
}