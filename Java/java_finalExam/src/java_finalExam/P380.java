package java_finalExam;

public class P380 {
	public static void main(String[] args) {
		String st="a=3,b=5,c=6";
	
		String[] str =st.split(",");
		
		for(int i=0;i<str.length;i++)
			System.out.println(str[i]);
	}
}
