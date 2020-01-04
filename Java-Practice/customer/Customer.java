package customer;

/* Customer Information */
public class Customer {
	private String customerNo;
	private String password;
	private String phoneNum;
	private String name;
	private String gender;
	private int point;
	
	Customer(){
		this.customerNo = null;
		this.password = null;
		this.phoneNum = null;
		this.name = null;
		this.gender = null;
		this.point = 0;
	}
	
	/* Getter & Setter */
	


	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	/* Getter & Setter */
}
