package ex07.sawon;
import java.util.*;

public class Sawon {
	protected final int num=3;
	protected String[] name = new String[num];
	protected String[] position = new String[num];
	protected String[] department = new String[num];
	protected String[] phone = new String[num];
	Scanner sc = new Scanner(System.in);
	
	public Sawon(){
		for(int i=0;i<num;i++){
			System.out.println((i+1) + "`s INPUT");
			System.out.print("## INPUT NAME : ");
			name[i]=sc.next();
			System.out.print("## INPUT POSITION : ");
			position[i]=sc.next();
			System.out.print("## INPUT DEPARTMENT : ");
			department[i]=sc.next();
			System.out.print("## INPUT PHONE NUMBER : ");
			phone[i]=sc.next();
		}
	}
	
	/* SET GET */

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

	public String[] getPosition() {
		return position;
	}

	public void setPosition(String[] position) {
		this.position = position;
	}

	public String[] getDepartment() {
		return department;
	}

	public void setDepartment(String[] department) {
		this.department = department;
	}

	public String[] getPhone() {
		return phone;
	}

	public void setPhone(String[] phone) {
		this.phone = phone;
	}
	
	/* SET GET */
}

class Output extends Sawon{
	public void display(){
		System.out.println("###################");
		for(int i=0;i<num;i++){
			System.out.println("NAME : " + name[i]);
			System.out.println("POSITION : " + position[i]);
			System.out.println("DEPARTMENT : " + department[i]);
			System.out.println("PHONE NUMBER : " + phone[i]);
			System.out.println("###################");
		}
	}
}
