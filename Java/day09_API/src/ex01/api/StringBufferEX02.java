package ex01.api;

public class StringBufferEX02 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("This");
		System.out.println(sb);
		
		/* 뒤에 추가 */
		sb.append(" is  pencil");
		System.out.println(sb);
		
		/* 중간에 원하는 곳에 추가 */
		sb.insert(8, "my");
		System.out.println(sb);
		
		/* 원하는 위치에 교체 */
		sb.replace(8, 10, "your");
		System.out.println(sb);
		
		/* 길이 */
		sb.trimToSize();
		System.out.println(sb.capacity());
		
		/* 반대로 바꾸기 */
		sb.reverse();
		System.out.println(sb);
		
		/* ~길이까지 짜르기*/
		sb.setLength(5);
		System.out.println(sb);
	}
}
