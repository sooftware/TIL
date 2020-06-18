package project1;

import java.awt.EventQueue;
import java.util.LinkedList;
import java.util.Vector;

public class Main {
	public static void main(String[] args) {
		LinkedList component_name = new LinkedList(); // 재료 이름 저장할 리스트
		LinkedList component_num = new LinkedList(); // 재료 개수를 저장할 리스트
		LinkedList component_min = new LinkedList(); // 재료 조리시간을 저장할 리스트
		About_SQL sql = new About_SQL(); // SQL관련한 메소드가 있는 클래스
		Vector<Integer> receiveCode = new Vector<Integer>(3, 4); // 3개를 초기
																	// 사이즈로하고
																	// 넘칠때마다 4개씩
																	// 추가한다 (코드를
																	// 받는
																	// Vector)
		Vector<String> codeBuffer = new Vector<String>(3, 4);
		sql.connect_SQL();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI(codeBuffer, component_name, component_num, component_min);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}