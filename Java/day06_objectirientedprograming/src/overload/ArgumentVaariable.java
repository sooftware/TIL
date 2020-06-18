package overload;

public class ArgumentVaariable {
	public static void main(String[] args) {
		add(1);
		add(1,2,3,4,5);
		add(3,4,5);
		
		add("a","b","c");
		add("one","two","three","korea","love");
	}

	public static void add(int... x){
		int sum=0;
		for(int i=0;i<x.length;i++){
			sum+=x[i];
		}
		System.out.println("int sum="+sum);
	}
	
	
	
	public static void add(String... str){
		String sum="0";
		for(int i=0;i<str.length;i++){
			sum += str[i];
		}
		System.out.println("String sum="+sum);
	}
}
