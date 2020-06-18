package test;

import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		// ui화면에서 code와 수량이 넘어온다
		// for(int i=0;i<수량;i++){
		//	code에 해당하는 물품들 추가
		// }
		LinkedList component = new LinkedList();
		int code=301;
		int amount=2;
		Connect_SQL cs = new Connect_SQL();	// sql연결
		Overlap ov = new Overlap();
		
		/* 수량만큼 실행한다 */
		for(int i=0;i<amount;i++){
			cs.bring_SQL(code,component);
		}
		
		ov.plus(component);
		
		for(int i=0;i<component.size();i++){
			System.out.println(component);
		}
	}
}
