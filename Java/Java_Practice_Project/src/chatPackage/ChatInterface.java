package chatPackage;

/*
 * KwangWoon University
 * 2019년도 1학기 객체지향프로그래밍실습 
 * 개인프로젝트
 * 전자통신공학과 2014707073 김수환
 * 주제 : 멀티캐스트 다중 채팅 프로그램
 * Interface : 공통적으로 사용하는 전역상수들을 묶음
 */

public interface ChatInterface {
	public static final int PORT=8000;		/* 통신에 사용되는 Port */
	public static final String DATABASE_IP="localhost";		/* DataBase가 구축되어 있는 PC IP */
	public static final String MULTICAST_IP="224.128.1.5";		/* 멀티캐스트 통신에 사용되는 IP */
	public static final int EXCEPTION_OCCUR=0;	/* Exception이 발생했을 때 반환값 */
}
