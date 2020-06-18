package array;

public class ForeachTest {
	public static void main(String[] args) {
		int[] a={7,1,3,5,2};
		
		for(int i=0;i<a.length;i++){
			System.out.print(a[i] + "\t");
		}
		
		System.out.println("\n foreach - 확장 FOR문을 배워봅시당!!");
		//for (자료형 변수명 : 배열명 또는 컬렉션명) { 반복실행문; }
		for(int item : a){
			System.out.print(item + "\t");
		}
	}
}
