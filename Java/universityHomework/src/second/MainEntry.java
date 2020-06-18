package second;

public class MainEntry {
	public static void main(String[] args) {
		int aArray[] = new int[] { 1, 2, 3, 4, 5 }; 	// a라는 배열을 생성하고 {1,2,3,4,5}를 넣어준다
		int bArray[] = new int[] { 9, 8, 7, 6, 5 }; 	// b라는 배열을 생성하고 {9,8,7,6,5}를 넣어준다
		int aArrayAddress[] = aArray;	 // a는 a배열의 주소이므로 이 주소를 따로 저장해준다 (swap을 위함)
		int bArrayAddress[] = bArray; 	// b는 b배열의 주소이므로 이 주소를 따로 저장해준다 (swap을 위함)
		Swap sw = new Swap();

		printArray(aArray, bArray); 
		
		/* swap */
		aArray = sw.changeArrayAddress(bArrayAddress); 	// a배열 주소 -> b배열 주소로 변경
		bArray = sw.changeArrayAddress(aArrayAddress); 	// b배열 주소 -> a배열 주소로 변경
		/* swap */
		
		System.out.println("=====swap=====\n");
		printArray(aArray, bArray);
	}
	
	/* 인자로 받은 배열들을 출력해주는 메서드 */
	private static void printArray(int[] a, int[] b) {
		System.out.print("## 배열 aArray : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\n");
		System.out.print("## 배열 bArray : ");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println("\n");
	}
}

class Swap {
	/* 인자로 받은 배열의 주소로 바꿔주는 메서드 */
	public int[] changeArrayAddress(int changeAddress[]) {
		return changeAddress;
		// 바꿔주고 싶은 배열의 주소를 받아 return해준다
	}
}