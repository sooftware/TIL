package customer2;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainEntry implements PublicConstants {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		Scanner sc = new Scanner(System.in);
		CustomerDao dao = new CustomerDao();
		if(!dao.connect()) return;
		int mode = 0;

		System.out.println(TITLE);
		while (true) {
			/* User Interface */
			do {
				for (int i = 0; i < MENU_NUM; i++)
					System.out.print(MENUS[i]);
				mode = sc.nextInt();
			} while (mode < 0 || mode > MENU_NUM - 2);
			/* Execute to User`s Choice */
			if (mode == PRINT_CUSTOMER_LIST) dao.printCustomers();
			else if (mode == REGISTER_NEW_CUSTOMER) dao.insertNewbie();
			else if (mode == MODIFY_CUSTOMER_INFO) dao.updateInfo();
			else if (mode == LOOKUP_CUSTOMER_POINT) dao.lookupPoint();
			else if (mode == DELETE_CUSTOMER) dao.deleteInfo();
			else if (mode == EXIT) break;
			else System.out.println(FATAL_ELSE_MSG);
		}
	}
}
