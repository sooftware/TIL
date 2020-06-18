package problem;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		Gogaeck gg = new Gogaeck();
		HashMap<String,Integer> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);

		LinkedList list = new LinkedList();
		
		gg.input(map,list);
		gg.login(map,list,gg);
	}
}