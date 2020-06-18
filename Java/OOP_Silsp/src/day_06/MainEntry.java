package day_06;

public class MainEntry {
	public static void main(String[] args) {
		Person[] p = {new Person("È«±æµ¿",20),new Student("±è¼öÈ¯", 25,2014707073),new ForeignStudent("Ishmanof",40,12010101,"Ä«ÀÚÈå½ºÅº")};
		
		for(Person item : p) {
			System.out.println("## " + item.getClass().getSimpleName());
			item.print();
			System.out.println();
		}
	}
}
