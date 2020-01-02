package customer;

import java.util.ArrayList;
import java.util.Scanner;

public class MainEntry implements PublicConstants {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		int mode = -1;

		System.out.println(TITLE);
		while (true) {
			/* User Interface */
			do {
				for (int i = 0; i < MENU_NUM; i++)
					System.out.print(MENU[i]);
				mode = sc.nextInt();
			} while (mode < 0 || mode > 5);

			/* Execute to User`s Choice */
			CustomerManagement execute = new CustomerManagement(customerList);
			if (mode == 0) execute.printCustomerList();
			else if (mode == 1) customerList.add(execute.registerNewCustomer());
			else if (mode == 2) execute.modifyCustomerInfo();
			else if (mode == 3) execute.lookupCustomerPoint();
			else if (mode == 4) execute.deleteCustomer();
			else if (mode == 5) break;
			else System.out.println(FATAL_ELSE_MSG);
		}
	}
}
