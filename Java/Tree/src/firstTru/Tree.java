package firstTru;

import java.util.LinkedList;
import java.util.Scanner;

public class Tree {
	Node seed;
	Node current;
	
	public void startTree() {
		seed = new Node();
		seed.name="seed";
		
		current=new Node();
		current=seed;
		
		current.below=new LinkedList();
	}
	
	public void addTree() {
		Scanner sc=new Scanner(System.in);
		System.out.print("»õ·Î¿î Node Name : ");
		String name=sc.nextLine();
		LinkedList object=new LinkedList();
		object.add(name);
		current.below.add(object);
	}
}
