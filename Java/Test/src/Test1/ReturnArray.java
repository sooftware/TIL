package Test1;

public class ReturnArray {
	static int[] makeArray() {
		int temp[] = new int[4];
		for(int i = 0; i < temp.length;i++)
			temp[i] = i;
		return temp;
	}
}
