package customer2;

import java.util.HashMap;
import java.util.Scanner;

public class MainEntry implements PublicConstants {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, PersonalInfo> customers = new HashMap<String, PersonalInfo>(); // <customerNo, PersonalInfo>
		int mode = 0;

		System.out.println(TITLE);
		while (true) {
			/* User Interface */
			do {
				for (int i = 0; i < MENU_NUM; i++)
					System.out.print(MENUS[i]);
				mode = sc.nextInt();
			} while (mode < 0 || mode > MENU_NUM-2);

			/* Execute to User`s Choice */
			CustomerManagement execute = new CustomerManagement(customers);
			if (mode == PRINT_CUSTOMER_LIST) execute.printCustomers();
			else if(mode == REGISTER_NEW_CUSTOMER) execute.registerNewCustomer();
		}
	}
}
