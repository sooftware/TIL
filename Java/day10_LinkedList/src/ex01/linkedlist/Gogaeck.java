package ex01.linkedlist;
import java.util.*;

public class Gogaeck {
	private String name = new String();
	private String tel = new String();
	private String address = new String();
	
	public Gogaeck(){
		name="홍길동";
		tel="010-4564-4668";
		address="천안시";
	}
	
	public Gogaeck(String name,String tel,String address){
		this.name=name;
		this.tel=tel;
		this.address=address;
	}
	
	public void output(){
		System.out.println("NAME  : " + name);
		System.out.println("TEL  : " + tel);
		System.out.println("ADDRESS  : " + address);
	}
	
	
	
	/* SET GET */
	
	@Override
	public String toString() {
		return "Gogaeck [name=" + name + ", tel=" + tel + ", address=" + address + "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	/* SET GET */
}
