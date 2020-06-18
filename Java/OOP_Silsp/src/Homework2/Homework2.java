package Homework2;

/*
 * KwangWoon University
 * 전자통신공학과 2014707073 김수환
 * 객체지향프로그래밍 실습 Homework2
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/* 공유하는 상수들을 모아놓은 인터페이스 */
interface Constant{
	public static final int QUIZ_NUM=5;	/* 퀴즈의 개수 */
	public static final int COUNTRY_NUM=14;	/* encoding한 나라<->수도 개수 */
}

/* MainClass */
public class Homework2 {
	public static void main(String[] args) {
		Mapping map = new Mapping();
		HashMap<String, String> pair = map.mapping();
		Game game=new Game(pair);
	}
}

/* 실제 게임을 진행하는 클래스 */
class Game implements Constant{
	HashMap<String, String> pair;	/* <나라,수도>로 Mapping된 객체 */
	Scanner sc;	/* 입력받는데 쓰일 Scanner */
	
	/* Game 생성자 함수 */
	Game(HashMap<String, String> pair){
		this.pair=pair;	
		sc = new Scanner(System.in);
		Set<String> set	=pair.keySet();	/* pair의 Key부분을 Set로 변환 */
		Iterator it=set.iterator();		/* set를 검색해줄 Iterator 생성 */
		
		for(int i=0;i<QUIZ_NUM;i++) {
			String country=it.next().toString();	/* it로 검색한 결과를 country에 저장 */
			System.out.print(country + "의 수도는 ? : ");	/* 질문 출력 */
			String userInput = sc.nextLine();	/* 유저에게 입력받기 */
			
			/* 종료를 입력받으면 종료 */
			if(isQuit(userInput)) {
				System.out.println("게임 종료..");
				return;
			}
			
			/* 정답이 맞을 시 */
			if(isCorrect(pair.get(country),userInput)) System.out.println("정답입니다!");
			/* 정답이 아닐 시 */
			else {
				System.out.println("아닙니다!");
				System.out.println("정답은 " + pair.get(country) +"입니다!"); /* 정답확인하기 위함 */
			}
		}
		
		System.out.println("게임을 종료합니다.");
	}
	
	/* 종료를 입력했는지 확인하는 함수 */
	private boolean isQuit(String userInput) {
		return userInput.equals("종료");
	}
	
	/* 유저가 입력한 답이 실제 답과 일치하는지 확인하는 함수 */
	private boolean isCorrect(String rightAnswer,String userInput) {
		return rightAnswer.equals(userInput);
	}
}


/* 임의의 5개의 <나라, 수도>를 HashMap에 추가하는 클래스 */
class Mapping implements Constant{
	
	/* 외부 클래스에서 호출해서 mapping을 하는 함수 */
	/* 이 함수만 호출하면 알아서 해주도록 만듬 */
	public HashMap<String, String> mapping() {
		HashMap<Integer, String> encoding=null;		/* <숫자,나라> encoding */
		HashMap<String, String> capital=null;		/* <나라,수도> encoding */
		HashMap<String,String> result = new HashMap<String,String>();	/* 임의의 5개의 <나라,수도>를 저장하는 Map */
		int [] randNums;	/* 임의의 5개의 서로 다른 숫자를 저장하는 배열 */
		
		encoding=encodingCountry();
		capital=encodingCapital();
		randNums=putRandNums();
		
		for(int i=0;i<QUIZ_NUM;i++) {
			String country=encoding.get(randNums[i]);
			result.put(country, capital.get(country));
		}
		
		return result;
	}

	/* randNums 배열에 서로 다른 임의의 5개의 숫자를 저장하는 함수 */
	/* 범위는 0~COUNTRY_NUM-1의 숫자 */
	private int[] putRandNums() {
		Random rand = new Random();
		int [] randNums=new int[QUIZ_NUM];
		
		for(int i=0;i<QUIZ_NUM;i++) {
			int buf=rand.nextInt(COUNTRY_NUM-1);
			if(isExist(randNums,buf)) {
				i--; 
				continue;
			}else {
				randNums[i]=buf;
			}
		}
		return randNums;
	}
	
	/* 해당 숫자가 이미 배열에 존재하는지 체크하는 함수 */
	private boolean isExist(int[] arr,int num) {
		for(int i=0;i<arr.length;i++) {
			if(num==arr[i]) return true;
		}
		return false;
	}
	
	/* <나라,수도>를 미리 capital이라는 변수에 저장해놓는 함수 */
	private HashMap<String,String> encodingCapital(){
		HashMap<String, String> capital = new HashMap<String, String>();
		capital.put("프랑스", "파리");		capital.put("스페인", "마드리드");		capital.put("그리스", "아테네");
		capital.put("영국", "런던");		capital.put("한국", "서울");		capital.put("네덜란드", "암스테르담");		capital.put("독일", "베를린");
		capital.put("멕시코", "멕시코시티");		capital.put("미국", "워싱턴");		capital.put("베트남", "하노이");
		capital.put("브라질", "브라질리아");		capital.put("스웨덴", "스톡홀름");		capital.put("이집트", "카이로");		capital.put("이탈리아", "로마");

		return capital;
	}
	
	/* <숫자,나라>를 미리 encoding이라는 변수에 저장해놓는 함수 */
	private HashMap<Integer,String> encodingCountry(){
		HashMap<Integer, String> encoding = new HashMap<Integer, String>();
		encoding.put(0, "프랑스");		encoding.put(1, "스페인");		encoding.put(2, "그리스");
		encoding.put(3, "영국");		encoding.put(4, "한국");		encoding.put(5, "네덜란드");
		encoding.put(6, "독일");		encoding.put(7, "이집트");		encoding.put(8, "멕시코");		encoding.put(9, "미국");
		encoding.put(10, "베트남");		encoding.put(11, "브라질");		encoding.put(12, "스웨덴");		encoding.put(13, "이탈리아");
		return encoding;
	}
}
