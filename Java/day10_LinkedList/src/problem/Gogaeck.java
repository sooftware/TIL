package problem;
import java.util.*;

public class Gogaeck {
	private int password;
	Scanner sc = new Scanner(System.in);

	public Gogaeck(){
		password=0;
	}
	
	public void input(HashMap map,LinkedList list){
		int i=0,j=0;
		String con = new String();
		String name;
		int password;
		for(i=0;i<=j;i++){
			System.out.println("고객님의 정보를 입력해주세요\n\n");
			System.out.print("NAME : ");
			name=sc.next();
			list.add(name);
			System.out.print("TEL : ");
			list.add(sc.next());
			System.out.print("ADDRESS : ");
			list.add(sc.next());
			System.out.print("PASSWORD : ");
			password=sc.nextInt();
			list.add(password);
			
			//int a=parseInt(list.get(0).toString());
			
			map.put(name,password);
			
			while(true){
				System.out.print("계속 하시겠습니까?? (Y/N) : ");
				con=sc.next();
				
				if(con.charAt(0)=='Y'){
					j++;
					break;
				}else if(con.charAt(0)=='N'){
					break;
				}else if(con.charAt(0)=='y'){
					j++;
					break;
				}else if(con.charAt(0)=='n'){
					break;
				}
				else{
					System.out.println("잘못 입력하셨습니다!!");
				}
			}
		}
	}
	
	public void login(HashMap map,LinkedList list,Gogaeck gg){
		String NAME;
		int PASSWORD;
		
		while(true){
			System.out.println("조회하실 이름과 해당 비밀번호를 입력해주세요.\n");
			System.out.print("NAME : ");
			NAME=sc.next();
			System.out.print("PASSWORD : ");
			PASSWORD=sc.nextInt();
			System.out.println("");
			
			if(map.containsKey(NAME)){	// NAME에 해당하는 값을 map이 가지고 있다면
						if(map.get(NAME).equals(PASSWORD)){	// NAME해당하는 값을 가지고 있는 map의 키값이 PASSWORD와 같다면
							System.out.println("----------------------------------------");
							System.out.println("\n\n ##" + NAME + "고객님 반갑습니다!!");
							for(int i=0;i<list.size();i++){
								if(NAME.equals(list.get(i))){
									gg.output(list,i);
								}
							}
							break;
						}
						else{
							System.out.println("\n## 비밀번호가 틀렸습니다!!");
							break;
						}
			}
			else{
					System.out.println("\n\n ## 해당 이름에 해당하는 고객님이 계시지 않습니다 ㅜ.ㅜ");
					
			}
			break;
		}
	}
	
	public void output(LinkedList list,int num){
		System.out.println("NAME  : " + list.get(num));
		System.out.println("TEL  : " + list.get(num+1));
		System.out.println("ADDRESS  : " + list.get(num+2));
	}
}
