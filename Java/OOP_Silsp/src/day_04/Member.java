package day_04;

import java.util.Scanner;

public class Member {
	private String name;
	private String password;
	private String age;
	private String id;
	
	public Member(String name,String password,String age,String id) {
		this.name=name;
		this.password=password;
		this.age=age;
		this.id=id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
}
